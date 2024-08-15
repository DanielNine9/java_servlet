package test.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import test.bean.User;

public class UserDAO {

    public List<User> findAll(int page, int pageSize) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (Connection connection = JpaUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setInt(1, (page - 1) * pageSize);
            stmt.setInt(2, pageSize);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setFullname(rs.getString("fullname"));
                user.setAdmin(rs.getBoolean("isAdmin"));
                // set other properties...
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error occurred while fetching users.");
        }
        return users;
    }

    public long count() {
        String sql = "SELECT COUNT(*) FROM Users";
        try {
            ResultSet rs = JpaUtils.query(sql);
            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error occurred while counting users.");
        }
        return 0;
    }

    public static User create(User entity) {
        String sql = "INSERT INTO Users (id, fullname, isAdmin) VALUES (?, ?, ?)";
        try {
        	JpaUtils.update(sql, entity.getId(), entity.getFullname(), entity.getAdmin());
            System.out.println("User added successfully.");
            return entity;
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.err.println("Error occurred while adding the user.");
            return null;
        }
    }

    public static User update(User entity) {
        String sql = "UPDATE Users SET fullname = ?, isAdmin = ? WHERE id = ?";
        try {
        	JpaUtils.update(sql, entity.getFullname(), entity.getAdmin(), entity.getId());
            System.out.println("User updated successfully.");
            return entity;
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.err.println("Error occurred while updating the user.");
            return null;
        }
    }

    public User remove(String id) {
        User user = findById(id);
        if (user == null) {
            System.err.println("User not found.");
            return null;
        }
        String sql = "DELETE FROM Users WHERE id = ?";
        try {
        	JpaUtils.update(sql, id);
            System.out.println("User deleted successfully.");
            return user;
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.err.println("Error occurred while deleting the user.");
            return null;
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (ResultSet rs = JpaUtils.query(sql)) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setFullname(rs.getString("fullname"));
                user.setAdmin(rs.getBoolean("isAdmin"));
                // set other properties...
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error occurred while fetching all users.");
        }
        return users;
    }

    public User findById(String id) {
        String sql = "SELECT * FROM Users WHERE id = ?";
        try (Connection connection = JpaUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setFullname(rs.getString("fullname"));
                user.setAdmin(rs.getBoolean("admin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error occurred while finding user by ID.");
        }
        return null;
    }
}
