import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSubjects {


    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(Config.DB_URL, Config.USER, Config.PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "insert into Subjects values (2, 'English');";
            statement.executeUpdate(sql);
            sql = "insert into Subjects values (3, 'Economic');";
            statement.executeUpdate(sql);
            System.out.println("Data inserted to table successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
