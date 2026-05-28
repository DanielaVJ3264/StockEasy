package stockEasy.persistence.mapper;

import stockEasy.domain.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoRowMapper implements RowMapper<Producto> {

    @Override
    public Producto mapRow(ResultSet rs) throws SQLException {

        Producto producto = new Producto();

        producto.setId(rs.getInt("id"));
        producto.setNombre(rs.getString("nombre"));
        producto.setDescripcion(rs.getString("descripcion"));
        producto.setCantidad(rs.getInt("cantidad"));
        producto.setPrecio(rs.getDouble("precio"));

        return producto;
    }
}
