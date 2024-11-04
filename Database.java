package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    // Database URL
    private static final String DATABASE_URL = "jdbc:sqlite:resources/quiz.db"; // Ensure the path is correct

    // Method to establish a connection to the database
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println("Connection to SQLite failed: " + e.getMessage());
        }
        return conn;
    }
}
