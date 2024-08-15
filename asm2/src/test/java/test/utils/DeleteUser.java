package test.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUser {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433/polyoe";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "1234";

    public static void main(String[] args) {
        String userId = "testuser";
        deleteUser(userId);
    }

    public static void deleteUser(String userId) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the ID parameter in the prepared statement
            statement.setString(1, userId);

            // Execute the DELETE statement
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User with ID " + userId + " was successfully deleted.");
            } else {
                System.out.println("No user found with ID " + userId + ".");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error occurred while deleting the user.");
        }
    }
}
