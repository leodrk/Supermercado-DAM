package Supermercado.dao;

import Supermercado.model.Producto;

public interface ProductoDAO {

    public void guardar(Producto producto);

    public void borrarProducto(Producto producto);

    public void actualizarProducto();

    public void borrarTabla();

    Producto recuperar(int codigo);
}
