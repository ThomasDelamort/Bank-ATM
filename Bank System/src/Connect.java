import java.sql.*;

public class Connect {
    Connection c;
    Statement s;

    public Connect() {
        try {
            c = DriverManager.getConnection(
                    "jdbc:mysql://BankSystem",
                    "root",
                    "Paredes776_677"
            );
            s = c.createStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
