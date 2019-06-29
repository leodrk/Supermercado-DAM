package Supermercado.dao;

import Supermercado.model.Usuario;

public interface UsuarioDAO {
    void guardar(Usuario usuario);
    void borrar (Usuario usuario);
    Usuario recuperar (String nombreUsuario);
}
