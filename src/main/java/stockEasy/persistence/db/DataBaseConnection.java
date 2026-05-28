package stockEasy.persistence.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static DataBaseConnection instance;

    private Connection connection;

    private static final String URL =
            "jdbc:mysql://localhost:3306/stockeasy";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    private DataBaseConnection() {

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {

            throw new RuntimeException("Error de conexión a la base de datos", e);
        }
    }

    public static DataBaseConnection getInstance() {

        if (instance == null) {

            instance = new DataBaseConnection();
        }

        return instance;
    }

    public Connection getConnection() {

        return connection;
    }
}