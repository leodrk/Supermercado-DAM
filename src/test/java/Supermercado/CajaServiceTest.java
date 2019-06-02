package Supermercado;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Supermercado.dao.ProductoDAO;
import Supermercado.dao.JDBC.JDBCProductoDAO;
import Supermercado.model.Caja;
import Supermercado.model.Producto;
import Supermercado.service.CajaService;

public class CajaServiceTest {
	
	private CajaService cajaService;
	private Caja caja;
	private Producto producto;
	private ProductoDAO dao;
	
	@Before
    public void setUP(){
		dao = new JDBCProductoDAO();
        caja = new Caja();
        producto = new Producto(1, "Manaos", 50);
        cajaService = new CajaService(caja);
    }
	
	@Test
	public void testRegistroUnaManaosDeCodigo1() {
		dao.guardar(producto);
		cajaService.registrarProducto(1);
		assertTrue(caja.getCosteTotalActual() == 50);
		assertTrue(caja.getProductosACobrar().size() == 1);
		dao.borrarProducto(producto);
	}
}
