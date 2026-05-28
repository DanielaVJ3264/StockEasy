package stockEasy.service;

import stockEasy.domain.Producto;
import stockEasy.service.portinput.ProductoService;
import stockEasy.service.portoutput.ProductoPersistencePort;
import stockEasy.util.TypeValidator;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService {

    private final ProductoPersistencePort productoPersistencePort;

    public ProductoServiceImpl(ProductoPersistencePort productoPersistencePort) {
        this.productoPersistencePort = productoPersistencePort;
    }

    @Override
    public Producto createProductoService() {

        Producto producto = new Producto();

        producto.setId(TypeValidator.validateInt("Ingrese el id del producto"));
        producto.setNombre(TypeValidator.validateString("Ingrese el nombre del producto"));
        producto.setDescripcion(TypeValidator.validateString("Ingrese la descripción"));
        producto.setCantidad(TypeValidator.validateInt("Ingrese la cantidad"));
        producto.setPrecio(TypeValidator.validateDouble("Ingrese el precio"));

        return productoPersistencePort.createProductoRepository(producto);
    }

    @Override
    public Producto updateProductoService(int id) {

        Producto producto = productoPersistencePort.getProductoById(id);

        if (id == producto.getId()) {

            System.out.println("Seleccione el dato a actualizar \n" +
                    "1. Id \n" +
                    "2. Nombre \n" +
                    "3. Descripción \n" +
                    "4. Cantidad \n" +
                    "5. Precio");

            int option = TypeValidator.validateInt("Opción: ");

            switch (option) {

                case 1:
                    producto.setId(TypeValidator.validateInt("Actualizar id"));
                    break;

                case 2:
                    producto.setNombre(TypeValidator.validateString("Actualizar nombre"));
                    break;

                case 3:
                    producto.setDescripcion(TypeValidator.validateString("Actualizar descripción"));
                    break;

                case 4:
                    producto.setCantidad(TypeValidator.validateInt("Actualizar cantidad"));
                    break;

                case 5:
                    producto.setPrecio(TypeValidator.validateDouble("Actualizar precio"));
                    break;

                default:
                    System.out.println("Seleccione una opción válida");
            }
        }

        return producto;
    }

    @Override
    public Optional<Producto> getProductoById(int id) {

        Producto producto = productoPersistencePort.getProductoById(id);

        if (id == producto.getId()) {

            System.out.println(
                    "Id: " + producto.getId() + "\n" +
                            "Nombre: " + producto.getNombre() + "\n" +
                            "Descripción: " + producto.getDescripcion() + "\n" +
                            "Cantidad: " + producto.getCantidad() + "\n" +
                            "Precio: " + producto.getPrecio()
            );

        } else {
            System.out.println("Producto no encontrado");
        }

        return Optional.ofNullable(producto);
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoPersistencePort.getAllProductos();
    }

    @Override
    public void deleteProducto(int id) {

           productoPersistencePort.deleteProductoRepository(id);
    }
}
