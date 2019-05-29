package Supermercado.dao;

import Supermercado.Producto;

public interface ProductoDAO {

    public void guardar(Producto producto);

    //public Producto recuperar(String nombreProducto);

    public void borrarProducto(Producto producto);

    public void actualizarProducto();

    public void borrarTabla();

    Producto recuperar(int codigo);
}
