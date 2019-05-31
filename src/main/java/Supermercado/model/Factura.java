package Supermercado.model;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private List<Producto> productosAbonados = new ArrayList<>();
    private double dineroAbonado = 0.0d;
    private double vuelto = 0.0d;

    public Factura(List<Producto> productos, double dinero) {
        productosAbonados = productos;
        dineroAbonado = dinero;
        vuelto = calcularVuelto();
    }

    private double calcularVuelto() {
        double precioTotal = productosAbonados.stream().mapToDouble(Producto::getPrecio).sum();
        return dineroAbonado - precioTotal;
    }

    public List<Producto> getProductosAbonados() {
        return productosAbonados;
    }

    public void setProductosAbonados(List<Producto> productosAbonados) {
        this.productosAbonados = productosAbonados;
    }

    public double getDineroAbonado() {
        return dineroAbonado;
    }

    public void setDineroAbonado(double dineroAbonado) {
        this.dineroAbonado = dineroAbonado;
    }

    public double getVuelto() {
        return vuelto;
    }

    public void setVuelto(double vuelto) {
        this.vuelto = vuelto;
    }
}
