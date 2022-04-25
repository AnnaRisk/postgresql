import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CB2 {
    public static Connection main(String[] args) {

            try {
                String url = "jdbc:postgresql://localhost:5432/postgres";
                String username = "postgres"; //your my sql username here
                String password = "mysecretpassword"; //your mysql password here

                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(url, username, password);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            return null;

    }
}
