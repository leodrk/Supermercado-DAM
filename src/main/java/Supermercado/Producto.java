package Supermercado;

public class Producto  {

    private int precio;
    private String nombre;

    public Producto (String unNombre, int unPrecio){
        setPrecio(unPrecio);
        setNombre(unNombre);
    }


    public Producto() {
	}


	public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}