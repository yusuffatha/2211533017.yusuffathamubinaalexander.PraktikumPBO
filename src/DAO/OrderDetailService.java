package DAO;

import config.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailService {

    public void save(String orderId, String product, String status, int harga) {
        String sql = "INSERT INTO order_detail (order_id, product, status, harga) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, orderId);
            stmt.setString(2, product);
            stmt.setString(3, status);
            stmt.setInt(4, harga);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
