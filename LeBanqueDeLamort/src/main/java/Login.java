import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel lbl, userLbl, passLbl;
    JTextField cardNumber, pinNumber;
    JButton logIn, clear, signUp;

    Menu menu;

    public Login() {
        setTitle("Banque De LaMort");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/Bank.png"));
        Image i2 = i.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(110, 60, 50, 50);
        add(image);


        lbl = new JLabel("Welcome to BDM");
        lbl.setFont(new Font("Montserrat", Font.BOLD, 38));
        lbl.setBounds(195, 70, 450, 30);
        add(lbl);

        userLbl = new JLabel("Card Number: ");
        userLbl.setFont(new Font("Montserrat", Font.BOLD, 22));
        userLbl.setBounds(100, 175, 200, 30);
        add(userLbl);

        cardNumber = new JTextField();
        cardNumber.setBounds(260, 175, 250, 30);

        add(cardNumber);

        passLbl = new JLabel("Pin: ");
        passLbl.setFont(new Font("Montserrat", Font.BOLD, 22));
        passLbl.setBounds(100, 230, 200, 30);
        add(passLbl);

        pinNumber = new JPasswordField();
        pinNumber.setBounds(260, 230, 250, 30);
        add(pinNumber);

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

        logIn.addActionListener(this);
        signUp.addActionListener(this);
        clear.addActionListener(this);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==logIn) {
                Connect connect = new Connect();
                String cardNo = cardNumber.getText();
                String pin = pinNumber.getText();
                String query = String.format("SELECT * FROM clients where cardno = %s and pin = %s", cardNo, pin);

                ResultSet rs = connect.execQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Menu(cardNo).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } else if (e.getSource() == signUp) {
                // Sign up
            } else {
                cardNumber.setText("");
                pinNumber.setText("");
            }
        } catch (Exception ae) {
            System.out.println("An Error Occurred: "+ae.getMessage());
        }
    }

    static void main() {
        new Login();
    }

}
