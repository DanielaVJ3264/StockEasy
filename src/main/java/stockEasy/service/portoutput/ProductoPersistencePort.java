package stockEasy.service.portoutput;

import stockEasy.domain.Producto;

import java.util.List;

public interface ProductoPersistencePort {

    Producto createProductoRepository(Producto producto);

    Producto getProductoById(int id);

    List<Producto> getAllProductos();

    Producto updateProductoRepository(int id);

    void deleteProductoRepository(int id);
}