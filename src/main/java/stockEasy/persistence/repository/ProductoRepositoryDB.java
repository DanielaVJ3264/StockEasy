package stockEasy.persistence.repository;

import stockEasy.domain.Producto;
import stockEasy.persistence.mapper.RowMapper;
import stockEasy.service.portoutput.ProductoPersistencePort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

        List<Producto> productos = new ArrayList<>();

        String sql = "SELECT * FROM producto";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Producto producto = (Producto) rowMapper.mapRow(rs);

                productos.add(producto);

                System.out.println(
                        "Id: " + producto.getId() +
                                " | Nombre: " + producto.getNombre() +
                                " | Descripción: " + producto.getDescripcion() +
                                " | Cantidad: " + producto.getCantidad() +
                                " | Precio: " + producto.getPrecio()
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener productos", e);
        }

        return productos;
    }

    @Override
    public Producto updateProductoRepository(int id) {
        return null;
    }

    @Override
    public void deleteProductoRepository(int id) {

        String sql = "DELETE FROM producto WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println("Producto eliminado correctamente");

            } else {

                System.out.println("Producto no encontrado");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar producto", e);
        }
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
