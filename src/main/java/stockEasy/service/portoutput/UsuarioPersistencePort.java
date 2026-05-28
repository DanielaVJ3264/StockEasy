package stockEasy.service.portoutput;

import stockEasy.domain.Usuario;

import java.util.List;

public interface UsuarioPersistencePort {

    Usuario createUsuarioRepository(Usuario usuario);

    Usuario getUsuarioById(int id);

    List<Usuario> getAllUsuarios();

    Usuario updateUsuarioRepository(int id);

    void deleteUsuarioRepository(int id);
}