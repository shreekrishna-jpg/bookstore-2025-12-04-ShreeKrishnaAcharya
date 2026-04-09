package csd214.bookstore.mysql;

import csd214.bookstore.pojos.Football;

import java.sql.*;
import java.util.UUID;

public class JdbcFootballApp {

    private static final String URL = "jdbc:mysql://localhost:3333/bookstore";
    private static final String USER = "csd214";
    private static final String PASS = "itstudies12345";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

            createTable(conn);

            System.out.println("--- INSERTING ---");
            Football f1 = new Football();
            f1.setName("Football Pro");
            f1.setPrice(29.99);
            f1.setProductId(UUID.randomUUID().toString());
            insertFootball(conn, f1);

            System.out.println("--- READING ---");
            listFootballs(conn);

            System.out.println("--- UPDATING ---");
            updateFootballPrice(conn, "Football Pro", 35.0);

            System.out.println("--- DELETING ---");
            deleteFootball(conn, "Football Pro");

            listFootballs(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection conn) throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS footballs (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "product_id VARCHAR(36), " +
                "name VARCHAR(255), " +
                "price DOUBLE)";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'footballs' ready.");
        }
    }

    private static void insertFootball(Connection conn, Football f) throws SQLException {

        String sql = "INSERT INTO footballs (product_id, name, price) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, f.getProductId());
            ps.setString(2, f.getName());
            ps.setDouble(3, f.getPrice());
            ps.executeUpdate();
            System.out.println("Saved: " + f.getName());
        }
    }

    private static void listFootballs(Connection conn) throws SQLException {

        String sql = "SELECT * FROM footballs";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.printf("ID: %d | UUID: %s | Name: %s | Price: $%.2f%n",
                        rs.getInt("id"),
                        rs.getString("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price"));
            }
        }
    }

    private static void updateFootballPrice(Connection conn, String name, double newPrice) throws SQLException {

        String sql = "UPDATE footballs SET price = ? WHERE name = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newPrice);
            ps.setString(2, name);
            int rows = ps.executeUpdate();
            System.out.println("Updated " + rows + " football(s).");
        }
    }

    private static void deleteFootball(Connection conn, String name) throws SQLException {

        String sql = "DELETE FROM footballs WHERE name = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.executeUpdate();
            System.out.println("Deleted football: " + name);
        }
    }
}