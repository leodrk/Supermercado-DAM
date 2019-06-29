package Supermercado.Service;

import Supermercado.dao.JDBC.JDBCUsuarioDAO;
import Supermercado.dao.UsuarioDAO;
import Supermercado.model.Usuario;
import Supermercado.model.exceptions.UsuarioNoExistente;

public class UsuarioService {
    private UsuarioDAO dao;

    public UsuarioService(){
        dao= new JDBCUsuarioDAO();
    }

    public boolean comprobarUsuario(String nombreUsuario, String password){
        Usuario u = dao.recuperar(nombreUsuario);
        if (u == null){
            //throw new UsuarioNoExistente(nombreUsuario);
            return false;
        }
        return u.comprobarPassword(password);
    }
}
