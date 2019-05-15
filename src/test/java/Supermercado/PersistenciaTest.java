package Supermercado;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class PersistenciaTest {

	@Test
	void testGuardarYRecuperarCoca() {
		Persistencia p = new Persistencia();
		Producto coca = new Producto("Coca",10);
		p.guardar(coca);
		Producto cocaRecuperada = p.recuperar("Coca");
		assertEquals (coca.getNombre(), cocaRecuperada.getNombre());
		p.borrarTabla();
	}
}