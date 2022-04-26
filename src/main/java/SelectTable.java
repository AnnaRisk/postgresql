import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTable {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(Config.DB_URL, Config.USER, Config.PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "select * from Students;";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Данные студента");
                System.out.println("\tid: " + rs.getInt("id"));
                System.out.println("\tNumber_group: " + rs.getInt("Number_group"));
                System.out.println("\tFIO: " + rs.getString("FIO"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
