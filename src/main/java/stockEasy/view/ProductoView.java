package stockEasy.view;

import stockEasy.domain.Producto;
import stockEasy.service.ProductoServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ProductoView {

    Scanner sc = new Scanner(System.in);

    private final ProductoServiceImpl productoServiceImpl;

    public ProductoView(ProductoServiceImpl productoServiceImpl) {

        this.productoServiceImpl = productoServiceImpl;
    }

    public void createProducto() {

        productoServiceImpl.createProductoService();
    }

    public void getProductoById(int id) {

        productoServiceImpl.getProductoById(id);
    }

    public List<Producto> getAllProductos() {

        return productoServiceImpl.getAllProductos();
    }

    public void updateProducto(int id) {

        productoServiceImpl.updateProductoService(id);
    }

    public void deleteProducto(int id) {

        System.out.println("Estoy en el view");

        productoServiceImpl.deleteProducto(id);
    }
}
