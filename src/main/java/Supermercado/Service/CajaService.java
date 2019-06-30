package Supermercado.Service;
import Supermercado.dao.ProductoDAO;
import Supermercado.dao.JDBC.JDBCProductoDAO;
import Supermercado.model.Caja;
import Supermercado.model.Producto;

public class CajaService {

    private ProductoDAO dao;
    private Caja caja;
    private String cajero;

    

    public CajaService (Caja caja) {
        this.setCaja(caja);
        this.setDao(new JDBCProductoDAO());
    }

    public CajaService(Caja caja, String cajero) {
    	this.setCaja(caja);
    	this.setCajero(cajero);
    	this.setDao(new JDBCProductoDAO());
    }
    
    public void setCajero(String cajero) {
    	this.cajero = cajero;
    }

	public Producto registrarProducto (int codigo) {
        Producto producto = this.getDao().recuperar(codigo);
        if (producto != null) {
        getCaja().addProducto(producto);
        }
        return producto;
    }

    public Producto getProducto (int codigo){
        return this.dao.recuperar(codigo);
    }

	public ProductoDAO getDao() {
		return dao;
	}

	public void setDao(ProductoDAO dao) {
		this.dao = dao;
	}

	public double getTotalVentaActual() {
		return this.getCaja().getCosteTotalActual();
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public String getCajero() {
		return cajero;
	}
}