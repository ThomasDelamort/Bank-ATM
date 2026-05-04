import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Menu extends JFrame{
    final int height = 850;
    final int width = 1080;

    int imgWidth = 400;
    int imgHeight = 250;

    JLabel Currency = new JLabel();
    JLabel bal = new JLabel();
    JLabel card = new JLabel();
    JLabel user = new JLabel();
    JLabel valThru = new JLabel();

    private String cardNumber;
    private String username;
    private String fullName;
    private double balance;


    public Menu(String username) {
        this.username = username;
        // Load Data
        loadData();


        setTitle("Main Menu");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        Currency.setText("$");
        Currency.setFont(new Font("Poppins", Font.BOLD, 35));
        Currency.setBounds(445, 50, 500, 50);
        add(Currency);

        String money = String.valueOf(getBalance());
        bal.setText(money);
        bal.setFont(new Font("Poppins", Font.BOLD, 35));
        bal.setBounds(490, 50, 500, 50);
        add(bal);

        user.setText(getFullName());
        user.setFont(new Font("Poppins", Font.BOLD, 16));
        user.setForeground(Color.orange);
        user.setBounds(359, 360, 500, 20);
        add(user);

        valThru.setText("18/27");
        valThru.setFont(new Font("Poppins", Font.BOLD, 12));
        valThru.setForeground(Color.orange);
        valThru.setBounds(500, 342, 500, 20);
        add(valThru);


        card.setText(maskAccountNumber(getCardNumber()));
        card.setFont(new Font("Poppins", Font.BOLD, 16));
        card.setForeground(Color.orange);
        card.setBounds(359, 300, 500, 20);
        add(card);



        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/BDM.png")));
        Image img = icon.getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel image = new JLabel(scaledIcon);
        image.setBounds(343, 145, imgWidth, imgHeight);
        add(image);


        // Transactions

    }

    public void loadData() {
        String username = getUsername();
        try {
            Connect con = new Connect();
            String q = String.format("select cardno, balance, fullname from clients where username = '%s';", username);
            ResultSet res = con.execQuery(q);

            while (res.next()) {
                setCardNumber(res.getString("cardno"));
                setBalance(res.getDouble("balance"));
                setFullName(res.getString("fullname"));

            }
            System.out.printf("Success: \n" +
                    "username = %s\n" +
                    "balance = %.2f", this.username, this.balance);
        } catch(SQLException e) {
            System.out.println("An Error Occured: "+e.getMessage());
        }
    }

    public String maskAccountNumber(String number) {
        String last4 = number.substring(number.length() -4);
        return "XXXX XXXX XXXX "+last4;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    //tester
    static void main(String[] args) {
        new Menu("").setVisible(true);
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
