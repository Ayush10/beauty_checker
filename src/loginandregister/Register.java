package loginandregister;

import database.SQLConnection;
import main.Intro;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Register extends JFrame {

    SQLConnection connection = new SQLConnection();

    private JPanel contentPane;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JLabel idLabel;

//    Connection conn = null;
//    PreparedStatement pst = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register frame = new Register();
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
    public Register() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(320, 180, 630, 355);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(196, 196, 196));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        firstNameField = new JTextField();
        firstNameField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        firstNameField.setBorder(null);
        firstNameField.setBounds(341, 131, 259, 31);
        contentPane.add(firstNameField);
        firstNameField.setColumns(10);

        lastNameField = new JTextField();
        lastNameField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        lastNameField.setBorder(null);
        lastNameField.setColumns(10);
        lastNameField.setBounds(341, 173, 259, 31);
        contentPane.add(lastNameField);

        emailField = new JTextField();
        emailField.setBorder(null);
        emailField.setText("");
        emailField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        emailField.setColumns(10);
        emailField.setBounds(341, 215, 259, 31);
        contentPane.add(emailField);

        JLabel firstName = new JLabel("First Name");
        firstName.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        firstName.setForeground(Color.WHITE);
        firstName.setBounds(239, 131, 92, 31);
        contentPane.add(firstName);

        JLabel lastName = new JLabel("Last Name");
        lastName.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        lastName.setForeground(Color.WHITE);
        lastName.setBounds(239, 173, 92, 31);
        contentPane.add(lastName);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(239, 215, 92, 31);
        contentPane.add(emailLabel);

        JLabel passLabel = new JLabel("Password");
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        passLabel.setBounds(239, 256, 92, 31);
        contentPane.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        passwordField.setBorder(null);
        passwordField.setBounds(341, 257, 259, 31);
        contentPane.add(passwordField);

        JButton doneButton = new JButton("Done");
        doneButton.setForeground(Color.WHITE);
        doneButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        doneButton.setBorder(null);
        doneButton.setBackground(new Color(147, 112, 219));
        doneButton.setBounds(527, 313, 73, 31);
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                getIdUser();
                insertDatabase();
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });
        contentPane.add(doneButton);

//        JLabel label = new JLabel("X");
//        label.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                dispose();
//            }
//        });
//        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        label.setHorizontalAlignment(SwingConstants.CENTER);
//        label.setForeground(Color.WHITE);
//        label.setFont(new Font("Century Gothic", Font.BOLD, 16));
//        label.setBounds(574, 11, 46, 14);
//        contentPane.add(label);

        JLabel imageLabel = new JLabel("");
        imageLabel.setIcon(new ImageIcon(Register.class.getResource("/Images/Register.jpg")));
        imageLabel.setBounds(-12, 86, 297, 224);
        contentPane.add(imageLabel);

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

        JLabel registerLabel = new JLabel("Register");
        registerLabel.setOpaque(true);
        registerLabel.setBorder(null);
        registerLabel.setBackground(new Color(147, 122, 219));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        registerLabel.setForeground(Color.WHITE);
        registerLabel.setBounds(407, 68, 125, 38);
        contentPane.add(registerLabel);

//        setUndecorated(true);
    }

//    private int getIdUser() {
//        int id = 0;
//        connection.setConn();
//        connection.executeSQL("SELECT * FROM person ORDER BY id DESC LIMIT 1");
//        try {
//            connection.rs.first();
//            idLabel.setText(String.valueOf(connection.rs.getInt("id")));
//            id = Integer.parseInt(idLabel.getText());
//            id++;
//            idLabel.setText(String.valueOf(id));
//
//        } catch (NumberFormatException | SQLException e) {
//            e.printStackTrace();
//        }
//        return id;
//    }

//    public void insertDatabase() {
//        ControlPerson cod = new ControlPerson();
//        ModelPerson mod = new ModelPerson();
//
////        mod.setId(Integer.parseInt(idLabel.getText()));
//        mod.setFirstName(firstNameField.getText());
//        mod.setLastName(lastNameField.getText());
//        mod.setEmail(emailField.getText());
//        mod.setPassword(String.valueOf(passwordField.getText()));
//        cod.insert(mod);
//    }

    public void insertDatabase() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String pass = String.valueOf(passwordField.getText());

        if (firstName.equals("")) {
            JOptionPane.showMessageDialog(null, "Add your first name");
        } else if (lastName.equals("")) {
            JOptionPane.showMessageDialog(null, "Add your last name");
        } else if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Add your email!!");
        } else if (pass.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter your password");
        }

        PreparedStatement preparedStatement, preparedStatement1;

        String registerQuery = "INSERT INTO person (firstName, lastName, email, password) VALUES (?, ?, ?, ?)";
//        String loginQuery = "INSERT INTO login(email, pass) VALUES(?, ?)";

        try {
            preparedStatement = SQLConnection.getConnection().prepareStatement(registerQuery);
//            preparedStatement1 = SQLConnection.getConnection().prepareStatement(loginQuery);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, pass);

//            preparedStatement1.setString(1, email);
//            preparedStatement1.setString(2, pass);
            preparedStatement.executeUpdate();
//            preparedStatement1.executeUpdate();

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Congratulations!! You are registered.");
            }

        } catch (SQLException sqlException) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, sqlException);
        }
//
//
    }


}
