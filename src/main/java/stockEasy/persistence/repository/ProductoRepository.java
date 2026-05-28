package stockEasy.persistence.repository;

import stockEasy.domain.Producto;
import stockEasy.service.portoutput.ProductoPersistencePort;

import java.util.ArrayList;
import java.util.List;

public class ProductoRepository implements ProductoPersistencePort {

    List<Producto> productos = new ArrayList<>();

    @Override
    public Producto createProductoRepository(Producto producto) {

        productos.add(producto);

        for (Producto producto1 : productos) {
            System.out.println(
                    producto1.getId() + " " +
                            producto1.getNombre() + " " +
                            producto1.getCantidad()
            );
        }

        return producto;
    }

    @Override
    public Producto getProductoById(int id) {

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }

        return null;
    }

    @Override
    public List<Producto> getAllProductos() {

        for (Producto producto : productos) {
            System.out.println(
                    producto.getId() + " " +
                            producto.getNombre() + " " +
                            producto.getCantidad()
            );
        }

        return productos;
    }

    @Override
    public Producto updateProductoRepository(int id) {

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }

        return null;
    }

    @Override
    public void deleteProductoRepository(int id) {

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                productos.remove(producto);
                System.out.println("Producto eliminado");
                return;
            }
        }

        System.out.println("Producto no encontrado");
    }
}