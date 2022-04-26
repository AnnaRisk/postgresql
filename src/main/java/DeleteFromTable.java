import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteFromTable {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(Config.DB_URL, Config.USER, Config.PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "delete from Students where id = 0;";
            statement.executeUpdate(sql);
            System.out.println("Record was deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
