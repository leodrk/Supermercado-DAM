package Supermercado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Persistencia  {

    public Persistencia() {
    }

    public void guardar(Producto producto) {
        this.executeWithConnection(conn -> {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO productos VALUES (?,?)");
            ps.setInt(1, producto.getPrecio());
            ps.setString(2, producto.getNombre());
            ps.execute();

            if (ps.getUpdateCount() != 1) {
                throw new RuntimeException("No se inserto el personaje " + producto);
            }
            ps.close();

            return null;
        });
    }
    
	public Producto recuperar(String nombreProducto) {
		return this.executeWithConnection(conn -> {
			PreparedStatement ps = 
					conn.prepareStatement("SELECT * FROM productos WHERE nombre=?");
			ps.setString(1, nombreProducto);
			ResultSet resultSet = ps.executeQuery();
			Producto producto = null;
			while(resultSet.next()) {
				if(producto != null) {
					throw new RuntimeException("Existe mas de un producto con el nombre " + nombreProducto);
				}	
				producto = new Producto(resultSet.getString("nombre"), resultSet.getInt("precio"));
			}
			ps.close();
			return producto;
		});
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
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado?user=root&password=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
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
