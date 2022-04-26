import java.sql.*;

public class SelectTableSub {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(Config.DB_URL, Config.USER, Config.PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "select * from Subjects;";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Данные предмета");
                System.out.println("\tid: " + rs.getInt("id"));
                System.out.println("\tname_subject: " + rs.getString("name_subject"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
