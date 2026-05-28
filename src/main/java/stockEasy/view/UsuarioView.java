package stockEasy.view;

import stockEasy.domain.Usuario;
import stockEasy.service.UsuarioServiceImpl;

import java.util.List;
import java.util.Scanner;

public class UsuarioView {

    Scanner sc = new Scanner(System.in);

    private final UsuarioServiceImpl usuarioServiceImpl;

    public UsuarioView(UsuarioServiceImpl usuarioServiceImpl) {

        this.usuarioServiceImpl = usuarioServiceImpl;
    }

    public void createUsuario() {

        usuarioServiceImpl.createUsuarioService();
    }

    public void getUsuarioById(int id) {

        usuarioServiceImpl.getUsuarioById(id);
    }

    public List<Usuario> getAllUsuarios() {

        return usuarioServiceImpl.getAllUsuarios();
    }

    public void updateUsuario(int id) {

        usuarioServiceImpl.updateUsuarioService(id);
    }

    public void deleteUsuario(int id) {

        System.out.println("Estoy en el view");

        usuarioServiceImpl.deleteUsuario(id);
    }
    public boolean loginUsuario(String username, String password) {

        return usuarioServiceImpl
                .loginUsuarioService(username, password);
    }
}
