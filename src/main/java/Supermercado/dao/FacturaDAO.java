package Supermercado.dao;

import Supermercado.model.Factura;

public interface FacturaDAO {
    void guardar(Factura factura);
    void borrar (Factura factura);
    double getRecaudacionTotal();
    Factura recuperar(Factura factura);
}
