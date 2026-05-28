package stockEasy.service.portinput;

import stockEasy.domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuario createUsuarioService();

    Usuario updateUsuarioService(int id);

    Optional<Usuario> getUsuarioById(int id);

    List<Usuario> getAllUsuarios();

    void deleteUsuario(int id);

}