import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableStudents {


    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(Config.DB_URL, Config.USER, Config.PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "create table Students (\n" +
                    "    id int not null,\n" +
                    "    Number_group int not null,\n" +
                    "    FIO varchar(255),\n" +
                    "    primary key (id)\n" +
                    ");";
            statement.executeUpdate(sql);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
