package Supermercado;

import static org.junit.Assert.assertEquals;

import Supermercado.dao.JDBC.JDBCProductoDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class JDBCProductoDAOTest {

private JDBCProductoDAO dao = new JDBCProductoDAO();

	@Before
	public void setUp(){
	}

	@After
	public void clear(){

	}

	@Test
	public void testGuardarYRecuperarCoca() {

		Producto coka = new Producto(777, "coka", 100);
		dao.guardar(coka);

		Producto cocaRecuperada = dao.recuperar(coka.getCodigo());
		assertEquals (coka.getNombre(), cocaRecuperada.getNombre());
		dao.borrarProducto(coka);
	}
}