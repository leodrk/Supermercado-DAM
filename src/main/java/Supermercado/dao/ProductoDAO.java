package Supermercado.dao;

import Supermercado.model.Producto;

public interface ProductoDAO {

    public void guardar(Producto producto);

    //public Producto recuperar(String nombreProducto);

    public void borrarProducto(Producto producto);

    public void actualizarProducto(Producto producto);
    public void actualizarStock(Producto producto);

    public void borrarTabla();

    Producto recuperar(int codigo);

    int getLastCodigo();

}
