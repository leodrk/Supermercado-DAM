package Supermercado.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private List<Producto> productosAbonados = new ArrayList<>();
    private double dineroAbonado = 0.0d;
    private double vuelto = 0.0d;
    private Date fechaDeEmision;
    private int codigo;
    
    
    public Factura(List<Producto> productos, double dinero) {
        productosAbonados = productos;
        dineroAbonado = dinero;
        vuelto = calcularVuelto();
        fechaDeEmision = new Date(new java.util.Date().getTime());
    }

    public Factura(int codigo, List<Producto> productos, double dinero) {
        this.codigo = codigo;
        productosAbonados = productos;
        dineroAbonado = dinero;
        vuelto = calcularVuelto();
        //fechaDeEmision = new Date();
        fechaDeEmision = new Date(new java.util.Date().getTime());
    }


    public Factura(int codigo, List<Producto> productos) {
    	this.codigo = codigo;
		productosAbonados = productos;
		fechaDeEmision = new Date(new java.util.Date().getTime());
	}

	private double calcularVuelto() {
        double precioTotal = productosAbonados.stream().mapToDouble(p -> p.getPrecio() * p.getCantidad()).sum();
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

    public Date getFechaDeEmision() {
        return fechaDeEmision;
    }

    public void setFechaDeEmision(Date fechaDeEmision) {
        this.fechaDeEmision = fechaDeEmision;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getDineroObtenido() {
        return dineroAbonado - vuelto;
    }
}
