package Supermercado.dao.JDBC;

import Supermercado.model.Producto;
import Supermercado.dao.ConnectionBlock;
import Supermercado.dao.ProductoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCProductoDAO implements ProductoDAO {

    public JDBCProductoDAO() {
    }

    public void guardar(Producto producto) {
        this.executeWithConnection(conn -> {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO productos (codigo, nombre, precio, cantidad) VALUES (?,?,?,?)");
            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
			ps.setDouble(3, producto.getPrecio());
			ps.setDouble(4, producto.getCantidad());
            ps.execute();

            if (ps.getUpdateCount() != 1) {
                throw new RuntimeException("No se inserto el producto con el codigo " + producto.getCodigo());
            }
            ps.close();

            return null;
        });
    }
    
	public Producto recuperar(int unCodigo) {
		return this.executeWithConnection(conn -> {
			PreparedStatement ps =
					conn.prepareStatement("SELECT * FROM productos WHERE codigo=?");
			ps.setInt(1, unCodigo);
			ResultSet resultSet = ps.executeQuery();
			Producto producto = null;
			while(resultSet.next()) {
				if(producto != null) {
					throw new RuntimeException("Existe mas de un producto con el codigo " + unCodigo);
				}
				producto = new Producto(resultSet.getInt("codigo"),resultSet.getString("nombre"), resultSet.getInt("precio"));
			}
			ps.close();
			return producto;
		});
	}

	@Override
	public void borrarProducto(Producto producto) {
		this.executeWithConnection(conn -> {
			PreparedStatement ps =
					conn.prepareStatement("DELETE "
							+ "FROM productos "
							+ "WHERE codigo='"+producto.getCodigo()+"'");
			ps.execute();
			ps.close();
			return null;
		});
	}

	@Override
	public void actualizarProducto() {

	}

	public void borrarTabla() {
		this.executeWithConnection(conn -> {
			PreparedStatement ps = 
					conn.prepareStatement("DELETE FROM productos");
			ps.execute();
			ps.close();
			return null;
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
