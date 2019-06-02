package Supermercado.service;

import Supermercado.dao.ProductoDAO;
import Supermercado.dao.JDBC.JDBCProductoDAO;
import Supermercado.model.Caja;
import Supermercado.model.Producto;

public class CajaService {
	
	private Caja caja;
	private static ProductoDAO productoDAO = new JDBCProductoDAO();
	
	public CajaService (Caja caja) {
		this.caja= caja;
	}
	
	public void registrarProducto (int codigo) {
		Producto producto = this.productoDAO.recuperar(codigo);
		this.caja.addProducto(producto);
	}

}
