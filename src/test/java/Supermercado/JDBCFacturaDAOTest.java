package Supermercado;

import Supermercado.dao.JDBC.JDBCFacturaDAO;
import Supermercado.model.Factura;
import Supermercado.model.Producto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class JDBCFacturaDAOTest {
    private JDBCFacturaDAO dao = new JDBCFacturaDAO();

    @Before
    public void setUp(){
    }

    @After
    public void clear(){
    }

    @Test
    public void guardarYRecuperarFactura(){
        /* */
        List<Producto> productos = new ArrayList<>();
        Producto p1 = new Producto(10, "manaos", 50.0d);
        Producto p2 = new Producto(15, "pitusas", 40.5d);

        productos.add(p1);
        productos.add(p2);

        Factura factura = new Factura(01, productos, 100.0d);

        dao.guardar(factura);

        Factura facturaRecuperada = dao.recuperar(factura);
        assertTrue (facturaRecuperada.getCodigo()== factura.getCodigo());
        dao.borrar(factura);
    }

    @Test
    public void calcularRecaudacionTotal(){
        List<Producto> productos1 = new ArrayList<>();
        List<Producto> productos2 = new ArrayList<>();
        Producto p1 = new Producto(10, "manaos", 50.0d);
        Producto p2 = new Producto(15, "pitusas", 40.0d);
        Producto p3 = new Producto(15, "fulbito", 10.0d);

        productos1.add(p1);
        productos1.add(p2);

        productos2.add(p3);
        Factura factura1 = new Factura(02, productos1, 100.0d);
        Factura factura2 = new Factura(03, productos2, 100.0d);

        dao.guardar(factura1);
        dao.guardar(factura2);

        assertTrue(dao.getRecaudacionTotal() == 100.0d);

        dao.borrar(factura1);
        dao.borrar(factura2);
    }
}
