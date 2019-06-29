package Supermercado.model.exceptions;

public class UsuarioNoExistente  extends RuntimeException {
    private String nombre;

    public UsuarioNoExistente (String nombreUsuario){
        printStackTrace();
        nombre=nombreUsuario;
    }
    @Override
    public String getMessage() {
        return ("el usuario " + this.nombre + " no se encuentra registrado");
    }
}
