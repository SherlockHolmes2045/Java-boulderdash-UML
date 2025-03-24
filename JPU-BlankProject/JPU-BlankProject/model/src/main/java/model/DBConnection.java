package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class DBConnection.
 *
 * @author Jean-Aymeric Diet
 */
final class DBConnection {
    /**
     * The instance.
     */
    private static DBConnection instance = null;

    /**
     * The connection.
     */
    private Connection connection;

    /**
     * Instantiates a new DB connection.
     */
    public DBConnection() {
        this.open();
    }

    /**
     * Gets the single instance of DBConnection.
     *
     * @return single instance of DBConnection
     */
    public static synchronized DBConnection getInstance() {
        if (DBConnection.instance == null) {
            DBConnection.instance = new DBConnection();
        }
        return DBConnection.instance;
    }

    /**
     * Open.
     *
     * @return the boolean
     */
    private void open() {
        final DBProperties dbProperties = new DBProperties();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(), dbProperties.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    public Connection getConnection() {
        return this.connection;
    }
}
