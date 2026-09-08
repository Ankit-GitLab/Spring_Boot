import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TransactionsDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/demo_dp";
    private static final String USER = "root";
    private static final String PASSWORD = "Ankit@123";
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
            System.out.println("Connected to the database!");

            // Order, OrderItems
            // INSER INTO ORDER
            int orderId = insertOrder(conn, 101, "ANKIT", 2000.0);

            // INSERT INTO ORDER ITEM
            inserOrderItem(conn, orderId, "Laptop01", 1, 2000.0);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int insertOrder(Connection conn, int i, String ankit, double v) {
    }
}
