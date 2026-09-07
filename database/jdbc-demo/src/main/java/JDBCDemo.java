import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/demo_dp";
    private static final String USER = "root";
    private static final String PASSWORD = "Ankit@123";
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                System.out.println("Connection closed!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
