package Supermercado.Service;

import Supermercado.dao.ProductoDAO;
import Supermercado.dao.JDBC.JDBCProductoDAO;
import Supermercado.model.Caja;

public class CajaService {
	
	private ProductoDAO dao = new JDBCProductoDAO();
	private Caja caja;
	
	public CajaService (Caja caja) {
		this.caja = caja;
	}

	public void registrarProducto(int codigo) {
		this.caja.addProducto(this.dao.recuperar(codigo));
	}
}
