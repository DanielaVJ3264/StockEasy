package stockEasy.persistence.repository;

import stockEasy.domain.Usuario;
import stockEasy.service.portoutput.UsuarioPersistencePort;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository implements UsuarioPersistencePort {

    List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario createUsuarioRepository(Usuario usuario) {

        usuarios.add(usuario);

        for (Usuario usuario1 : usuarios) {
            System.out.println(
                    usuario1.getId() + " " +
                            usuario1.getUsername()
            );
        }

        return usuario;
    }

    @Override
    public Usuario getUsuarioById(int id) {

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }

        return null;
    }

    @Override
    public List<Usuario> getAllUsuarios() {

        for (Usuario usuario : usuarios) {
            System.out.println(
                    usuario.getId() + " " +
                            usuario.getUsername()
            );
        }

        return usuarios;
    }

    @Override
    public Usuario updateUsuarioRepository(int id) {

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }

        return null;
    }

    @Override
    public void deleteUsuarioRepository(int id) {

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuarios.remove(usuario);
                System.out.println("Usuario eliminado");
                return;
            }
        }

        System.out.println("Usuario no encontrado");
    }
}