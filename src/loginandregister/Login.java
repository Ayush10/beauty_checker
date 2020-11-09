package loginandregister;

import database.SQLConnection;
import main.Intro;
import main.Menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame {
    SQLConnection connection = new SQLConnection();

    private JPanel contentPane;
    private JTextField userField;
    private JPasswordField passwordField;
    private JLabel message_txt;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(320, 180, 700, 400);
//        setLocationRelativeTo(null);
//        setSize(700, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(196, 196, 196));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        userField = new JTextField();
        userField.setBorder(null);
        userField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        userField.setText("");
        userField.setBounds(347, 154, 259, 31);
        contentPane.add(userField);
        userField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBorder(null);
        passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        passwordField.setBounds(347, 201, 259, 31);
        contentPane.add(passwordField);

        JButton doneButton = new JButton("Done");
        doneButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        doneButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        doneButton.setBorder(null);
        doneButton.setForeground(new Color(255, 255, 255));
        doneButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        doneButton.setBackground(new Color(147, 112, 219));
        doneButton.setBounds(533, 273, 73, 31);
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        contentPane.add(doneButton);

        JLabel userLabel = new JLabel("User");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        userLabel.setBounds(254, 153, 65, 31);
        contentPane.add(userLabel);

        JLabel passLabel = new JLabel("Password");
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        passLabel.setBounds(253, 198, 84, 31);
        contentPane.add(passLabel);

        JLabel imageLabel = new JLabel("");
        imageLabel.setIcon(new ImageIcon(Login.class.getResource("/Images/Login (2).jpg")));
        imageLabel.setBounds(0, 22, 339, 348);
        contentPane.add(imageLabel);

        JLabel registerLabel = new JLabel("");
        registerLabel.setLocation(370, 300);
        registerLabel.setForeground(new Color(255, 255, 255));
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Register register = new Register();
                register.setVisible(true);
                dispose();
            }
        });
        contentPane.add(registerLabel);


//        JLabel lblNewLabel_2 = new JLabel("X");
//        lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        lblNewLabel_2.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                dispose();
//            }
//        });
//        lblNewLabel_2.setForeground(Color.WHITE);
//        lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
//        lblNewLabel_2.setBounds(590, 0, 30, 31);
//        contentPane.add(lblNewLabel_2);

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setOpaque(true);
        loginLabel.setBorder(null);
        loginLabel.setBackground(new Color(51, 204, 0));
        loginLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setBounds(418, 90, 107, 39);
        contentPane.add(loginLabel);

        JButton backButton = new JButton("Back");
        backButton.setBorder(null);
        backButton.setBackground(new Color(196, 196, 196));
        backButton.setForeground(new Color(147, 122, 219));
        backButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        backButton.setBounds(10, 10, 89, 23);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Intro intro = new Intro();
                intro.setVisible(true);
                dispose();
            }
        });
        contentPane.add(backButton);

//        setUndecorated(true);
    }


    public void login() {
//        connection.setConn();
//        try {
//            connection.executeSQL("SELECT * FROM login WHERE username='" + userField.getText() + "'");
//            connection.rs.first();
//            if (connection.rs.getString("password").equals(passwordField.getText())) {
//                JOptionPane.showMessageDialog(null, "Login Successful!!");
//                Menu menu = new Menu();
//                menu.setVisible(true);
//                dispose();
//            } else {
//                JOptionPane.showMessageDialog(null, "Incorrect Password!!");
//                message_txt.setText("Invalid Password!");
//                message_txt.setForeground(new Color(202, 66, 66));
//            }
//        } catch (NullPointerException | SQLException ex) {
//            message_txt.setText("User does not exists!");
//            message_txt.setForeground(new Color(202, 66, 66));
//        }
//        connection.disconnect();

        PreparedStatement ps;
        ResultSet rs;
        String uname = userField.getText();
        String pass = String.valueOf(passwordField.getPassword());

        String query = "SELECT * FROM person WHERE email=? AND password=?";
        try {
            ps = SQLConnection.getConnection().prepareStatement(query);

            ps.setString(1, uname);
            ps.setString(2, pass);

            rs = ps.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"You are Logged in");
                Menu menu = new Menu();
                menu.setVisible(true);
//                menu.pack();
                menu.setLocationRelativeTo(null);
                menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
