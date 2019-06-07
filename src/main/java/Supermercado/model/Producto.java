package Supermercado.model;

public class Producto  {

    private int codigo;
    private String nombre;
    private double precio;

    public Producto() {
    }

    public Producto (String unNombre, double unPrecio){
        setPrecio(unPrecio);
        setNombre(unNombre);
    }
    public Producto (int unCodigo, String unNombre, double unPrecio){
        setCodigo(unCodigo);
        setPrecio(unPrecio);
        setNombre(unNombre);
    }

    public Producto (int unCodigo, String unNombre, int unPrecio){
        setCodigo(unCodigo);
        setPrecio(unPrecio);
        setNombre(unNombre);
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
}