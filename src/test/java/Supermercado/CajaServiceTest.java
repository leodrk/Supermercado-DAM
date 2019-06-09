package Supermercado;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Supermercado.Service.CajaService;
import Supermercado.dao.JDBC.JDBCProductoDAO;
import Supermercado.model.Caja;
import Supermercado.model.Producto;
import static org.mockito.Mockito.*;

public class CajaServiceTest {


    private CajaService service;
    private Caja caja;

    @Before
    public void setUp() {
        this.caja = new Caja();
        this.service = new CajaService(caja);
        JDBCProductoDAO dao = mock(JDBCProductoDAO.class);
        this.service.setDao(dao);
        Producto jugo = new Producto (1101, "Jugo", 50);
        when(dao.recuperar(1101)).thenReturn(jugo);
    }

    @Test
    public void testRecuperarJugoDeNaranjaCodigo1101() {
        Producto producto = service.registrarProducto(1101);
        assertTrue(producto.getCodigo()==1101);
        assertTrue(caja.getCosteTotalActual() == 50);
        assertTrue(caja.getProductosACobrar().size() == 1);
    }

    @Test
    public void testFeo() {
    	JDBCProductoDAO d = new JDBCProductoDAO();
    	this.service.setDao(d);
    	this.service.registrarProducto(1102);
    	  assertTrue(caja.getProductosACobrar().size() == 1);
    }

}