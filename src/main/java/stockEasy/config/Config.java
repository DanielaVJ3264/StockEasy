package stockEasy.config;

import stockEasy.persistence.db.DataBaseConnection;
import stockEasy.persistence.mapper.ProductoRowMapper;
import stockEasy.persistence.mapper.RowMapper;
import stockEasy.persistence.mapper.UsuarioRowMapper;
import stockEasy.persistence.repository.ProductoRepositoryDB;
import stockEasy.persistence.repository.UsuarioRepositoryDB;
import stockEasy.service.ProductoServiceImpl;
import stockEasy.service.UsuarioServiceImpl;
import stockEasy.service.portoutput.ProductoPersistencePort;
import stockEasy.service.portoutput.UsuarioPersistencePort;
import stockEasy.userinterface.MenuApp;
import stockEasy.view.ProductoView;
import stockEasy.view.UsuarioView;

import java.sql.Connection;

public class Config {

    public static MenuApp createMenuApp() {

        Connection connection =
                DataBaseConnection.getInstance().getConnection();

        // Producto

        RowMapper productoRowMapper = new ProductoRowMapper();

        ProductoPersistencePort productoRepositoryDB =
                new ProductoRepositoryDB(connection, productoRowMapper);

        ProductoServiceImpl productoServiceImpl =
                new ProductoServiceImpl(productoRepositoryDB);

        ProductoView productoView =
                new ProductoView(productoServiceImpl);

        // Usuario

        RowMapper usuarioRowMapper = new UsuarioRowMapper();

        UsuarioPersistencePort usuarioRepositoryDB =
                new UsuarioRepositoryDB(connection, usuarioRowMapper);

        UsuarioServiceImpl usuarioServiceImpl =
                new UsuarioServiceImpl(usuarioRepositoryDB);

        UsuarioView usuarioView =
                new UsuarioView(usuarioServiceImpl);

        return new MenuApp(productoView, usuarioView);
    }
}