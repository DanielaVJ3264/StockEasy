package stockEasy.service.portinput;

import stockEasy.domain.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    Producto createProductoService();

    Producto updateProductoService(int id);

    Optional<Producto> getProductoById(int id);

    List<Producto> getAllProductos();

    void deleteProducto(int id);

}
