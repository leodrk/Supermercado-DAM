package Supermercado;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Supermercado.Service.CajaService;
import Supermercado.model.Caja;
import Supermercado.model.Producto;

public class CajaServiceTest {

    private CajaService service;
    private Caja caja;

    @Before
    public void setUp() {
        this.caja = new Caja();
        this.service = new CajaService(caja);
    }

    @Test
    public void testRecuperarJugoDeNaranjaCodigo1101() {
        Producto producto = service.registrarProducto(1101);
        assertTrue(producto.getCodigo()==1101);
        assertTrue(caja.getCosteTotalActual() == 50);
        assertTrue(caja.getProductosACobrar().size() == 1);
    }
}