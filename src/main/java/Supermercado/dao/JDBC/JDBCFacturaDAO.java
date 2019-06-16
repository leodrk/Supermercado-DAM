package Supermercado.dao.JDBC;

import Supermercado.dao.ConnectionBlock;
import Supermercado.dao.FacturaDAO;
import Supermercado.model.Factura;
import Supermercado.model.Producto;

import java.sql.*;
import java.util.ArrayList;

public class JDBCFacturaDAO implements FacturaDAO {

    public JDBCFacturaDAO(){}

    @Override
    public void guardar(Factura factura) {
        this.executeWithConnection(conn -> {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO facturas (codigo, dineroObtenido, fechaDeEmision) VALUES (?,?,?)");
           /* ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());*/
           ps.setInt(1, factura.getCodigo());
           ps.setDouble(2, factura.getDineroObtenido());
           ps.setDate(3, factura.getFechaDeEmision());
           ps.execute();

            if (ps.getUpdateCount() != 1) {
                throw new RuntimeException("No se inserto la facutra con el codigo " + factura.getCodigo());
            }
            ps.close();

            return null;
        });
    }

    @Override
    public void borrar(Factura factura) {
        this.executeWithConnection(conn -> {
            PreparedStatement ps =
                    conn.prepareStatement("DELETE "
                            + "FROM facturas "
                            + "WHERE codigo='"+factura.getCodigo()+"'");
            ps.execute();
            ps.close();
            return null;
        });
    }

    @Override
    public double getRecaudacionTotal() {
        return this.executeWithConnection(conn -> {
            PreparedStatement ps =
                    conn.prepareStatement("SELECT SUM(dineroObtenido) "
                            + "FROM facturas ");
            ResultSet result = ps.executeQuery();
            result.next();
            String sum = result.getString(1);
           // ps.execute();
            //return ps.executeQuery();
            return Double.parseDouble(sum);
            //return 0.0d;// result.getString("suma");
        });
       // return result.getString("suma");
    }

    @Override
    public Factura recuperar(Factura factura) {
        return this.executeWithConnection(conn -> {
            PreparedStatement ps =
                    conn.prepareStatement("SELECT * FROM facturas WHERE codigo=?");
            ps.setInt(1, factura.getCodigo());
            ResultSet resultSet = ps.executeQuery();
            Factura facturaRecuperada = null;
            while(resultSet.next()) {
                if(facturaRecuperada != null) {
                    throw new RuntimeException("No se encontro una factura con el codigo " + factura.getCodigo());
                }
                facturaRecuperada = new Factura(resultSet.getInt("codigo"),
                                                new ArrayList<Producto>(),
                                                resultSet.getDouble("dineroObtenido")
                                                );
                facturaRecuperada.setFechaDeEmision(resultSet.getDate("fechaDeEmision"));
            /*
                        resultSet.getInt("codigo"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("precio"));*/
            }
            /*codigo, dineroObtenido, fechaDeEmision*/
            ps.close();
            return facturaRecuperada;
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
