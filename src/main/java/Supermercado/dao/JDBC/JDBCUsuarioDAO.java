package Supermercado.dao.JDBC;

import Supermercado.dao.UsuarioDAO;
import Supermercado.model.Usuario;

import Supermercado.dao.ConnectionBlock;
import Supermercado.dao.ConnectionBlock;

import java.sql.PreparedStatement;
import Supermercado.dao.ConnectionBlock;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUsuarioDAO implements UsuarioDAO {

    public JDBCUsuarioDAO(){}


    public void guardar(Usuario usuario) {
        this.executeWithConnection(conn -> {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO usuarios (nombre, password) VALUES (?,?)");
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getPassword());
            ps.execute();

            if (ps.getUpdateCount() != 1) {
                throw new RuntimeException("No se inserto el usuario con el nombre " + usuario.getNombre());
            }
            ps.close();

            return null;
        });

    }

    @Override
    public void borrar(Usuario usuario) {
        this.executeWithConnection(conn -> {
            PreparedStatement ps =
                    conn.prepareStatement("DELETE "
                            + "FROM usuarios "
                            + "WHERE nombre='"+usuario.getNombre()+"'");
            ps.execute();
            ps.close();
            return null;
        });

    }

    @Override
    public Usuario recuperar(String nombreUsuario) {
        return this.executeWithConnection(conn -> {
            PreparedStatement ps =
                    conn.prepareStatement("SELECT * FROM usuarios WHERE nombre=?");
            ps.setString(1, nombreUsuario);
            ResultSet resultSet = ps.executeQuery();
            Usuario usuarioRecuperado = null;
            while(resultSet.next()) {
                if(usuarioRecuperado != null) {
                    throw new RuntimeException("Existe mas de un usuario con el nombre " + nombreUsuario);
                }
                usuarioRecuperado = new Usuario(resultSet.getString("nombre"),resultSet.getString("password"));
            }
            ps.close();
            return usuarioRecuperado;
        });
    }

    private <T> T executeWithConnection(ConnectionBlock<T> bloque) {
        Connection connection = this.openConnection();
        try {
            return bloque.executeWith(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Error no esperado", e);
        } finally {
            this.closeConnection(connection);
        }
    }


    private Connection openConnection() {
        try {
            //La url de conexion no deberia estar harcodeada aca
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado?user=root&password=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false");

            //return DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado?user=root&password=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false");
        } catch (SQLException e) {
            throw new RuntimeException("No se puede establecer una conexion", e);
        }
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error al cerrar la conexion", e);
        }
    }
}
