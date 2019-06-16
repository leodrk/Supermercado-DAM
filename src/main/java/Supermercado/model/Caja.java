package Supermercado.model;

import Supermercado.model.exceptions.DineroInsuficienteException;

import java.util.ArrayList;
import java.util.List;

public class Caja {

    private List<Producto> productosACobrar = new ArrayList<>();
    private double costeTotalActual = 0.0d;

    public void addProducto(Producto producto) {
        if (this.productosACobrar.stream().anyMatch( p -> producto.getCodigo() == p.getCodigo() )) {
        	this.getProducto(producto).agregarProducto();
        }
        else {
        	this.productosACobrar.add(producto);
        }
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

    //Precondicion: asume que el producto dado esta en la lista de productos a cobrar
    public Producto getProducto (Producto producto) {
    	for (int i = 0; i<= this.productosACobrar.size(); i++) {
    		if (this.productosACobrar.get(i).getCodigo() == producto.getCodigo()) {
    			return this.productosACobrar.get(i);
    		}
    	}
		return null;
    }
}