import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudents {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(Config.DB_URL, Config.USER, Config.PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "insert into Students values (0, 6401, 'Anna Rain Test2');";
            statement.executeUpdate(sql);
            sql = "insert into Students values (13, 6405, 'Masha Makarova Test2');";
            statement.executeUpdate(sql);
            System.out.println("Data inserted to table successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
