package futureclasses;

import accountinfo.AccountInfo;
import main.Menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BeautyComparision extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BeautyComparision frame = new BeautyComparision();
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
    public BeautyComparision() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(320, 180, 720, 600);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("Stay Tuned!!");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        label.setBounds(200, 131, 100, 26);
        contentPane.add(label);

        JLabel label1 = new JLabel("We will add this feature soon!!");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        label1.setBounds(200, 231, 400, 26);
        contentPane.add(label1);

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
//
//        JButton btnBack = new JButton("Back");
//        btnBack.setForeground(Color.WHITE);
//        btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 16));
//        btnBack.setBorder(null);
//        btnBack.setBackground(new Color(51, 204, 0));
//        btnBack.setBounds(491, 290, 114, 41);
//        btnBack.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                main.Menu menu = new Menu();
//                menu.setVisible(true);
//                dispose();
//            }
//        });
//        contentPane.add(btnBack);
//
//        JLabel lblNewLabel = new JLabel("Account Info");
//        lblNewLabel.setBackground(new Color(212, 77, 3));
//        lblNewLabel.setOpaque(true);
//        lblNewLabel.setForeground(Color.WHITE);
//        lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
//        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        lblNewLabel.setBounds(344, 69, 210, 41);
//        contentPane.add(lblNewLabel);
//
//        JLabel lblNewLabel_1 = new JLabel("Name  :");
//        lblNewLabel_1.setForeground(Color.WHITE);
//        lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
//        lblNewLabel_1.setBounds(344, 131, 72, 26);
//        contentPane.add(lblNewLabel_1);
//
//        JLabel nameLabel = new JLabel("Ayush Ojha");
//        nameLabel.setForeground(Color.WHITE);
//        nameLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
//        nameLabel.setBounds(400, 131, 100, 26);
//        contentPane.add(nameLabel);
//
//        JLabel lblEmail = new JLabel("Email  :");
//        lblEmail.setFont(new Font("Century Gothic", Font.PLAIN, 16));
//        lblEmail.setForeground(Color.WHITE);
//        lblEmail.setBounds(344, 168, 72, 26);
//        contentPane.add(lblEmail);
//
//        JLabel emailLabel = new JLabel("ayush@gmail.com");
//        emailLabel.setForeground(Color.WHITE);
//        emailLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
//        emailLabel.setBounds(400, 168, 200, 26);
//        contentPane.add(emailLabel);
//
//        JLabel lblNewLabel_2 = new JLabel("");
//        lblNewLabel_2.setIcon(new ImageIcon(AccountInfo.class.getResource("/Images/AccountInfo.jpg")));
//        lblNewLabel_2.setBounds(22, 50, 353, 281);
//        contentPane.add(lblNewLabel_2);
    }
}
