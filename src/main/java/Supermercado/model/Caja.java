package Supermercado.model;

import Supermercado.model.exceptions.DineroInsuficienteException;

import java.util.ArrayList;
import java.util.List;

public class Caja {

    private List<Producto> productosACobrar = new ArrayList<>();
    private double costeTotalActual = 0.0d;

    public void addProducto(Producto producto) {
        productosACobrar.add(producto);
        costeTotalActual += producto.getPrecio();
    }

    public List<Producto> getProductosACobrar() {
        return productosACobrar;
    }

    public void setProductosACobrar(List<Producto> productosACobrar) {
        this.productosACobrar = productosACobrar;
    }

    public double getCosteTotalActual() {
        return costeTotalActual;
    }

    public void setCosteTotalActual(double costeTotalActual) {
        this.costeTotalActual = costeTotalActual;
    }

    public void reiniciarCompra() {
        productosACobrar = new ArrayList<>();
        costeTotalActual = 0.0d;
    }

    public Factura abonarCompra(double dinero) {
        if (costeTotalActual <= dinero){
            return new Factura(productosACobrar, dinero);
        }
        else{
            throw new DineroInsuficienteException(costeTotalActual - dinero);
        }
    }
}