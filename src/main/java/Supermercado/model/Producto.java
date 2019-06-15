package Supermercado.model;

public class Producto  {

    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto() {
    }

    public Producto (String unNombre, double unPrecio){
        setPrecio(unPrecio);
        setNombre(unNombre);
        setCantidad(1);
    }
    public Producto (int unCodigo, String unNombre, double unPrecio){
        setCodigo(unCodigo);
        setPrecio(unPrecio);
        setNombre(unNombre);
        setCantidad(1);
    }

    public Producto (int unCodigo, String unNombre, int unPrecio){
        setCodigo(unCodigo);
        setPrecio(unPrecio);
        setNombre(unNombre);
    }

    @Override
    public String toString() {
        return (this.nombre + ": " + Double.toString(this.precio));
    }

    private void setCodigo(int unCodigo){
        this.codigo = unCodigo;
    }

	public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    public int getCodigo() {
        return codigo;
    }

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void agregarProducto() {
		this.cantidad++;
	}	
}