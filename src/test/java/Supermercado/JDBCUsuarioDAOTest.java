package Supermercado;

import Supermercado.dao.JDBC.JDBCUsuarioDAO;
import Supermercado.model.Usuario;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JDBCUsuarioDAOTest {
    private JDBCUsuarioDAO dao = new JDBCUsuarioDAO();


    @Before
    public void setUp(){
    }

    @After
    public void clear(){
    }

    @Test
    public void testGuardarYRecuperarUsuario(){
        Usuario usuario = new Usuario("as","12");
        Usuario usuarioRecuperado;
        dao.guardar(usuario);
        usuarioRecuperado = dao.recuperar(usuario.getNombre());

        assertEquals(usuario.getNombre(), usuarioRecuperado.getNombre());
        dao.borrar(usuario);
    }
}
