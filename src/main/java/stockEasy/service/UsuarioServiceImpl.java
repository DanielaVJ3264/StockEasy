package stockEasy.service;

import stockEasy.domain.Usuario;
import stockEasy.service.portinput.UsuarioService;
import stockEasy.service.portoutput.UsuarioPersistencePort;
import stockEasy.util.TypeValidator;

import java.util.List;
import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioPersistencePort usuarioPersistencePort;

    public UsuarioServiceImpl(UsuarioPersistencePort usuarioPersistencePort) {
        this.usuarioPersistencePort = usuarioPersistencePort;
    }

    @Override
    public Usuario createUsuarioService() {

        Usuario usuario = new Usuario();

        usuario.setId(TypeValidator.validateInt("Ingrese el id del usuario"));
        usuario.setUsername(TypeValidator.validateString("Ingrese el username"));
        usuario.setPassword(TypeValidator.validateString("Ingrese el password"));

        return usuarioPersistencePort.createUsuarioRepository(usuario);
    }

    @Override
    public Usuario updateUsuarioService(int id) {

        Usuario usuario = usuarioPersistencePort.getUsuarioById(id);

        if (id == usuario.getId()) {

            System.out.println("Seleccione el dato a actualizar \n" +
                    "1. Id \n" +
                    "2. Username \n" +
                    "3. Password");

            int option = TypeValidator.validateInt("Opción: ");

            switch (option) {

                case 1:
                    usuario.setId(TypeValidator.validateInt("Actualizar id"));
                    break;

                case 2:
                    usuario.setUsername(TypeValidator.validateString("Actualizar username"));
                    break;

                case 3:
                    usuario.setPassword(TypeValidator.validateString("Actualizar password"));
                    break;

                default:
                    System.out.println("Seleccione una opción válida");
            }
        }

        return usuario;
    }

    @Override
    public Optional<Usuario> getUsuarioById(int id) {

        Usuario usuario = usuarioPersistencePort.getUsuarioById(id);

        if (id == usuario.getId()) {

            System.out.println(
                    "Id: " + usuario.getId() + "\n" +
                            "Username: " + usuario.getUsername()
            );

        } else {
            System.out.println("Usuario no encontrado");
        }

        return Optional.ofNullable(usuario);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioPersistencePort.getAllUsuarios();
    }

    @Override
    public void deleteUsuario(int id) {

        System.out.println("Estoy en el service");

        usuarioPersistencePort.deleteUsuarioRepository(id);
    }
}