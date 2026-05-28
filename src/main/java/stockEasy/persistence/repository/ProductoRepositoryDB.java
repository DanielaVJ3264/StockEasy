package stockEasy.persistence.repository;

import stockEasy.domain.Producto;
import stockEasy.persistence.mapper.RowMapper;
import stockEasy.service.portoutput.ProductoPersistencePort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductoRepositoryDB implements ProductoPersistencePort {

    private final Connection connection;
    private final RowMapper rowMapper;

    public ProductoRepositoryDB(Connection connection, RowMapper rowMapper) {
        this.connection = connection;
        this.rowMapper = rowMapper;
    }

    @Override
    public Producto createProductoRepository(Producto producto) {

        String sql = "INSERT INTO producto (id, nombre, descripcion, cantidad, precio) VALUES (?,?,?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            setCustomParams(ps, producto);

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();

            if (keys.next()) {
                producto.setId(keys.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar producto", e);
        }

        return producto;
    }

    @Override
    public Producto getProductoById(int id) {
        return null;
    }

    @Override
    public List<Producto> getAllProductos() {
        return List.of();
    }

    @Override
    public Producto updateProductoRepository(int id) {
        return null;
    }

    @Override
    public void deleteProductoRepository(int id) {

    }

    // Helpers
    private void setCustomParams(PreparedStatement ps, Producto producto) throws SQLException {

        ps.setInt(1, producto.getId());
        ps.setString(2, producto.getNombre());
        ps.setString(3, producto.getDescripcion());
        ps.setInt(4, producto.getCantidad());
        ps.setDouble(5, producto.getPrecio());

    }
}
