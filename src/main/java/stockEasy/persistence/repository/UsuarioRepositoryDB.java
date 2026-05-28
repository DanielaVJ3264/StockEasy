package stockEasy.persistence.repository;

import stockEasy.domain.Usuario;
import stockEasy.persistence.mapper.RowMapper;
import stockEasy.service.portoutput.UsuarioPersistencePort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioRepositoryDB implements UsuarioPersistencePort {

    private final Connection connection;
    private final RowMapper rowMapper;

    public UsuarioRepositoryDB(Connection connection, RowMapper rowMapper) {
        this.connection = connection;
        this.rowMapper = rowMapper;
    }

    @Override
    public Usuario createUsuarioRepository(Usuario usuario) {

        String sql = "INSERT INTO usuario (id, username, password) VALUES (?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            setCustomParams(ps, usuario);

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();

            if (keys.next()) {
                usuario.setId(keys.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar usuario", e);
        }

        return usuario;
    }

    @Override
    public Usuario getUsuarioById(int id) {
        return null;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return List.of();
    }

    @Override
    public Usuario updateUsuarioRepository(int id) {
        return null;
    }

    @Override
    public void deleteUsuarioRepository(int id) {

    }
    @Override
    public Usuario loginUsuario(String username, String password) {

        String sql = "SELECT * FROM usuario WHERE username = ? AND password = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return (Usuario) rowMapper.mapRow(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al iniciar sesión", e);
        }

        return null;
    }

    // Helpers
    private void setCustomParams(PreparedStatement ps, Usuario usuario) throws SQLException {

        ps.setInt(1, usuario.getId());
        ps.setString(2, usuario.getUsername());
        ps.setString(3, usuario.getPassword());


    }
}
