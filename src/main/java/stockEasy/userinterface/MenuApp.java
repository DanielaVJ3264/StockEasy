package stockEasy.userinterface;

import stockEasy.persistence.db.DataBaseConnection;
import stockEasy.util.TypeValidator;
import stockEasy.view.ProductoView;
import stockEasy.view.UsuarioView;

import java.util.Scanner;

public class MenuApp {

    Scanner sc = new Scanner(System.in);

    private final ProductoView productoView;
    private final UsuarioView usuarioView;

    public MenuApp(ProductoView productoView, UsuarioView usuarioView) {

        this.productoView = productoView;
        this.usuarioView = usuarioView;
    }

    public void mainMenu() {

        System.out.println("Presione 1 para iniciar la Aplicación");

        int init = sc.nextInt();

        sc.nextLine();

        while (init != 0) {

            DataBaseConnection.getInstance().getConnection();

            System.out.println("""
                    Seleccione una opción
                    1. Registro Usuario
                    2. Gestión Productos
                    3. Salir
                    """);

            int option = sc.nextInt();

            sc.nextLine();

            switch (option) {

                case 1:
                    System.out.println("Registro Usuario");
                    usuarioView.createUsuario();
                    break;

                case 2:
                    System.out.println("Gestión Productos");
                    productoMenu();
                    break;

                case 3:
                    System.out.println("Salir del sistema");
                    init = 0;
                    break;

                default:
                    System.out.println("Ingrese una opción válida");
            }
        }
    }

    public void productoMenu() {

        System.out.println("Menú Producto");

        boolean init = true;

        sc.nextLine();

        while (init) {

            System.out.println("""
                    1. Crear Producto
                    2. Actualizar Producto
                    3. Ver Productos
                    4. Ver Producto por Id
                    5. Eliminar Producto
                    6. Volver
                    """);

            int opt = sc.nextInt();

            sc.nextLine();

            switch (opt) {

                case 1:
                    System.out.println("Crear Producto");
                    productoView.createProducto();
                    break;

                case 2:
                    System.out.println("Actualizar Producto");
                    productoView.updateProducto(
                            TypeValidator.validateInt("Ingrese el id del producto")
                    );
                    break;

                case 3:
                    System.out.println("Ver Productos");
                    productoView.getAllProductos();
                    break;

                case 4:
                    System.out.println("Ver Producto por Id");

                    int id = sc.nextInt();

                    productoView.getProductoById(id);
                    break;

                case 5:
                    System.out.println("Eliminar Producto");

                    int idDelete = sc.nextInt();

                    productoView.deleteProducto(idDelete);
                    break;

                case 6:
                    System.out.println("Volviendo al menú principal");
                    init = false;
                    break;

                default:
                    System.out.println("Seleccione una opción válida");
            }
        }
    }
}
