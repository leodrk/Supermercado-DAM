package Supermercado.model;

public class Usuario {
    private String nombre;
    private String password;

    public Usuario(){}

    public Usuario (String n, String p){
        this.nombre =n;
        this.password = p;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean comprobarPassword(String password) {
        return (this.getPassword().equals(password));
    }
}
