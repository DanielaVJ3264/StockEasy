package stockEasy.persistence.mapper;

import stockEasy.domain.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRowMapper implements RowMapper<Usuario> {

    @Override
    public Usuario mapRow(ResultSet rs) throws SQLException {

        Usuario usuario = new Usuario();

        usuario.setId(rs.getInt("id"));
        usuario.setUsername(rs.getString("username"));
        usuario.setPassword(rs.getString("password"));

        return usuario;
    }
}