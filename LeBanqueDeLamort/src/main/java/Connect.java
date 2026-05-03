import java.sql.*;

public class Connect {
    private Connection c;
    private Statement s;

    public Connect() {
        String url = "jdbc:mysql://127.0.0.1:3306/bank_login";
        String user = "root";
        String password = "Paredes776_677";
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
