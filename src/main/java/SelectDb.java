import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDb {

    public static void main(String[] args) {
        System.out.println("Connecting to database school...");
        try (Connection connection = DriverManager.getConnection(Config.DB_URL, Config.USER, Config.PASSWORD)) {
            System.out.println("Connected successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
