import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(Config.DB_URL, Config.USER, Config.PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "update Students set Number_group = 6407 where id = 3;";
            statement.executeUpdate(sql);
            System.out.println("Table was updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
