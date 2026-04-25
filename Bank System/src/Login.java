import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel lbl, userLbl, passLbl;
    JTextField userTxt, passTxt;
    JButton logIn, clear, signUp;

    public Login() {
        setTitle("BANK SYSTEM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500 );
        setLocationRelativeTo(null);
        setLayout(null);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/Bank.png"));
        Image i2 = i.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(110, 60, 50, 50);
        add(image);


        lbl = new JLabel("Welcome to ATM");
        lbl.setFont(new Font("Montserrat", Font.BOLD, 38));
        lbl.setBounds(195, 70, 375, 30);
        add(lbl);

        userLbl = new JLabel("Username: ");
        userLbl.setFont(new Font("Montserrat", Font.BOLD, 22));
        userLbl.setBounds(100, 175, 200, 30);
        add(userLbl);

        userTxt = new JTextField();
        userTxt.setBounds(260, 175, 250, 30);
        add(userTxt);

        passLbl = new JLabel("Password: ");
        passLbl.setFont(new Font("Montserrat", Font.BOLD, 22));
        passLbl.setBounds(100, 230, 200, 30);
        add(passLbl);

        passTxt = new JTextField();
        passTxt.setBounds(260, 230, 250, 30);
        add(passTxt);

        logIn = new JButton("LOG IN");
        logIn.setBounds(260, 300, 100, 30);
        logIn.setFont(new Font("Montserrat", Font.BOLD, 12));
        logIn.setForeground(Color.white);
        logIn.setBackground(Color.BLACK);
        logIn.setFocusable(false);
        logIn.setBorder(null);
        add(logIn);

        clear = new JButton("CLEAR");
        clear.setBounds(410, 300, 100, 30);
        clear.setFont(new Font("Montserrat", Font.BOLD, 12));
        clear.setForeground(Color.white);
        clear.setBackground(Color.BLACK);
        clear.setFocusable(false);
        clear.setBorder(null);
        add(clear);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(260, 350, 250, 30);
        signUp.setFont(new Font("Montserrat", Font.BOLD, 12));
        signUp.setForeground(Color.white);
        signUp.setBackground(Color.BLACK);
        signUp.setFocusable(false);
        signUp.setBorder(null);
        add(signUp);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Action
    }

    static void main() {
        new Login();
    }

}
