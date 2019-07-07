package Supermercado.Service;

import Supermercado.dao.JDBC.JDBCProductoDAO;
import Supermercado.dao.ProductoDAO;
import Supermercado.model.Producto;
import Supermercado.model.Usuario;

public class ProductService {
    private ProductoDAO dao;

    public ProductService(){dao = new JDBCProductoDAO();
    }

    public void registrarProducto(Producto producto){dao.guardar(producto);}

    public void actualizarStock(Producto producto) {dao.actualizarStock(producto);}

    public int getLastCodigo() {
        return dao.getLastCodigo();
    }

    public Producto getProduct(int codigo) {
        return dao.recuperar(codigo);
    }
}
