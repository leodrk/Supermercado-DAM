package Supermercado.Service;

import Supermercado.Interface.ventanas.paneles.ProductListPanel;
import Supermercado.dao.ProductoDAO;
import Supermercado.dao.JDBC.JDBCProductoDAO;
import Supermercado.model.Caja;
import Supermercado.model.Producto;

public class CajaService {

    private ProductoDAO dao;
    private Caja caja;

    

    public CajaService (Caja caja) {
        this.caja = caja;
        this.setDao(new JDBCProductoDAO());
    }

    public Producto registrarProducto (int codigo) {
        Producto producto = this.getDao().recuperar(codigo);
        if (producto != null) {
        caja.addProducto(producto);
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
		return this.caja.getCosteTotalActual();
	}
}