package main;

import loginandregister.Login;
import loginandregister.Register;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Intro extends JFrame {
    GraphicsDevice graphicsDevice;
    JFrame frame;
    private JPanel contentPane;
    private int x_axis;
    private int y_axis;
    private int currentScreenWidth;
    private int currentScreenHeight;
    boolean fullScreenSize = false;



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Intro frame = new Intro();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


//        new Intro();
    }

    /**
     * Create the frame.
     */
    public Intro() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsDevice = graphicsEnvironment.getDefaultScreenDevice(); // gets access to the full screen of the laptop or monitor
//        frame = new JFrame();
        currentScreenWidth = 630;
        currentScreenHeight = 400;
        setSize(currentScreenWidth, currentScreenHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        x_axis = 320;
        y_axis = 180;

//        setBounds(x_axis, y_axis, currentScreenWidth, currentScreenHeight);
////        checkFullScreen();
        contentPane = new JPanel();
        contentPane.setBounds(x_axis, y_axis, currentScreenWidth, currentScreenHeight);
        contentPane.setBackground(new Color(196, 196, 196));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton registerButton = new JButton("Register");
        registerButton.setBorder(null);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        registerButton.setBackground(new Color(147, 122, 219));
        registerButton.setBounds(255, 289, 111, 34);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register register = new Register();
                register.setVisible(true);
                dispose();
            }
        });
        contentPane.add(registerButton);

        JButton loginButton = new JButton("Login");
        loginButton.setBorder(null);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        loginButton.setBackground(new Color(51, 204, 0));
        loginButton.setBounds(255, 243, 111, 35);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });
        contentPane.add(loginButton);

        JLabel beautyLabel = new JLabel("Beauty");
        beautyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        beautyLabel.setForeground(new Color(123, 104, 238));
        beautyLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 35));
        beautyLabel.setBounds(149, 183, 146, 49);
        contentPane.add(beautyLabel);

        JLabel checkerLabel = new JLabel("Checker");
        checkerLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 35));
        checkerLabel.setForeground(new Color(51, 204, 0));
        checkerLabel.setBounds(305, 183, 138, 49);
        contentPane.add(checkerLabel);

//        JLabel lblNewLabel_1 = new JLabel("X");
//        lblNewLabel_1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                dispose();
//            }
//        });
//        lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//        lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
//        lblNewLabel_1.setForeground(Color.WHITE);
//        lblNewLabel_1.setBounds(574, 11, 46, 14);
//        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Intro.class.getResource("/Images/Frame0.jpg")));
        lblNewLabel_2.setBounds(167, 43, 261, 148);
        contentPane.add(lblNewLabel_2);

//        setUndecorated(true);
//        setFullScreen();
    }

    public void setFullScreen() {
        graphicsDevice.setFullScreenWindow(frame);
    }

}
