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

            System.out.println("""
                    Seleccione una opción
                    1. Registrar Usuario
                    2. Iniciar Sesión
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

                    System.out.println("=== INICIAR SESION ===");

                    String username =
                            TypeValidator.validateString("Ingrese username");

                    String password =
                            TypeValidator.validateString("Ingrese password");

                    boolean loginCorrecto =
                            usuarioView.loginUsuario(username, password);

                    if (loginCorrecto) {

                        System.out.println("Acceso concedido");

                        productoMenu();

                    } else {

                        System.out.println("Acceso denegado");
                    }

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

        while (init) {

            System.out.println("""
                    1. Crear Producto
                    2. Ver Productos
                    3. Eliminar Producto
                    4. Cerrar Sesión
                    """);

            int opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {

                case 1:

                    System.out.println("Crear Producto");
                    productoView.createProducto();
                    break;

                case 2:

                    System.out.println("Ver Productos");
                    productoView.getAllProductos();
                    break;

                case 3:

                    System.out.println("Eliminar Producto");

                    int idDelete =
                            TypeValidator.validateInt("Ingrese el id del producto");

                    productoView.deleteProducto(idDelete);
                    break;

                case 4:

                    System.out.println("Cerrando sesión");
                    init = false;
                    break;

                default:

                    System.out.println("Seleccione una opción válida");
            }
        }
    }
}