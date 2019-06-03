package Supermercado.Service;

import Supermercado.dao.ProductoDAO;
import Supermercado.dao.JDBC.JDBCProductoDAO;
import Supermercado.model.Caja;
import Supermercado.model.Producto;

public class CajaService {

    private ProductoDAO dao;
    private Caja caja;


    public CajaService (Caja caja) {
        this.caja = caja;
        this.dao = new JDBCProductoDAO();
    }

    public Producto registrarProducto (int codigo) {
        Producto producto = this.dao.recuperar(codigo);
        caja.addProducto(producto);
        return producto;
    }
}
