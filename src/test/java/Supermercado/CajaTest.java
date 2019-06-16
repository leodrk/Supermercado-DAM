package Supermercado;

import Supermercado.model.Caja;
import Supermercado.model.Factura;
import Supermercado.model.Producto;
import Supermercado.model.exceptions.DineroInsuficienteException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CajaTest {

    private Producto producto1;
    private Producto producto2;
    private Caja caja;


    @Before
    public void setUP(){
        caja = new Caja();
        producto1 = new Producto(10,"Manaos", 50.5);
        producto2 = new Producto(12, "Pitusas", 40.5);
        caja.addProducto(producto1);
        caja.addProducto(producto2);
    }

    @After
    public void clear(){
        caja.setCosteTotalActual(0.0d);
        caja.setProductosACobrar(new ArrayList<>());
    }


    @Test
    public void test01addProductosALaCaja(){
        /*
        * Dada Una Caja Que Tiene Guardados Los Productos "Manaos" De Coste 50.5 Y Pitusas De Coste 40.5
        * Si Pregunto Por El Coste Total Actual Me Deberia Devolver 90.0d
        * */

        assertTrue(caja.getCosteTotalActual()== 91.0d);
        assertEquals(caja.getProductosACobrar().size() , 2);
    }


    @Test
    public void test02ReiniciarCompra(){
        /*
        * Dada Una Caja Que Tiene Guardados Los Productos "Manaos" De Coste 50.5 Y Pitusas De Coste 40.5
        * si reinicio la compra entonces el coste total actual me deberia devolver 0 y los productos a cobrar deberian ser 0
        * */
        caja.reiniciarCompra();
        assertTrue(caja.getCosteTotalActual() == 0.0d);
        assertEquals(caja.getProductosACobrar().size() , 0);
    }

    @Test
    public void test03FinalizarCompra(){
        /*
         * Dada Una Caja Que Tiene Guardados Los Productos "Manaos" De Coste 50.5 Y Pitusas De Coste 40.5
         * si abono la compra con 100.0 me deberia devolver una factura que me diga que compre esos 2 productos,
         * que el coste fue de 91 pesos y que mi vuelto fue de 9.0d
         * */
        Factura factura = caja.abonarCompra(100.0d);

        assertEquals(factura.getProductosAbonados().size() , 2);
        assertTrue(factura.getDineroAbonado() == 100.0d);
        assertTrue(factura.getVuelto() == 9.00);
    }

    @Test(expected = DineroInsuficienteException.class)
    public void test03BFinalizarCompraConDineroInsuficienteException(){
        /*
         * Dada Una Caja Que Tiene Guardados Los Productos "Manaos" De Coste 50.5 Y Pitusas De Coste 40.5
         * si abono la compra con 50.0 me deberia devolver una excepcion diciendome la cantidad de pesos que me faltan abonar
         * */
        Factura factura = caja.abonarCompra(50.0d);
    }
}
