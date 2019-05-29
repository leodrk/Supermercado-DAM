package Supermercado;

public class Producto  {

    private int codigo;
    private String nombre;
    private int precio;


    public Producto (String unNombre, int unPrecio){
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

    public int getCodigo() {
        return codigo;
    }
}