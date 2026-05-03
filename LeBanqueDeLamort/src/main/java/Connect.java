import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;

public class Connect {
    private Connection c;
    private Statement s;

    Dotenv dotenv = Dotenv.load();
    public Connect() {
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.c = DriverManager.getConnection(url, user, password);
            this.s = c.createStatement();

        } catch (SQLException e) {
            System.out.println("Failed to connect database: "+e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet execQuery(String q) {
        ResultSet rsr = null;
        try {
            rsr = this.s.executeQuery(q);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return rsr;
    }
}
