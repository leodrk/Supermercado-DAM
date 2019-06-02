package Supermercado;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Supermercado.Service.CajaService;
import Supermercado.model.Caja;

public class CajaServiceTest {
	
	private CajaService cajaService;
	private Caja caja;
	
	@Before
	public void setUp() {
		this.caja = new Caja();
		this.cajaService = new CajaService(caja);
	}
	
	@Test
	public void testregistrarProductoJugoDeNaranjaCodigo1101() {
		this.cajaService.registrarProducto(1101);
		assertTrue (caja.getProductosACobrar().size() == 1);
		assertTrue (caja.getCosteTotalActual() == 50);
	}

}
