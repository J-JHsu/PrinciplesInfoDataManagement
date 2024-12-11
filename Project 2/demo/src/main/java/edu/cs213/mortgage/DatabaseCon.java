package edu.cs213.mortgage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCon {
    private static final String URL = ("jdbc:postgresql://localhost:5432/mydb");       // Database URL
    private static final String USER = ("postgres");     // Database User
    private static final String PASSWORD = ("owen");  // Database Password

    /**
     * Connects to the PostgreSQL database using environment variables.
     *
     * @return Connection object
     * @throws SQLException if connection fails
     */
    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully.");
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
            throw new SQLException("Driver not found", e);
        } catch (SQLException e) {
            System.err.println("Database connection failed.");
            throw e;
        }
    }
}
