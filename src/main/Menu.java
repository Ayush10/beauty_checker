package main;

import accountinfo.AccountInfo;
import camera.CameraFrame;
import futureclasses.BeautyComparision;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
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
    public Menu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(320, 180, 630, 400);
        contentPane = new JPanel();
        contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contentPane.setBackground(new Color(196, 196, 196));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton backButton = new JButton("Back");
        backButton.setBorder(null);
        backButton.setBackground(new Color(196, 196, 196));
        backButton.setForeground(new Color(147, 122, 219));
        backButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        backButton.setBounds(400, 12, 89, 23);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                menu.setVisible(true);
                dispose();
            }
        });
        contentPane.add(backButton);

        JButton beautyCheckerButton = new JButton("Beauty Checker");
        beautyCheckerButton.setForeground(Color.WHITE);
        beautyCheckerButton.setBorder(null);
        beautyCheckerButton.setBackground(new Color(51, 204, 0));
        beautyCheckerButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        beautyCheckerButton.setBounds(348, 94, 176, 34);
        beautyCheckerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CameraFrame cameraFrame = new CameraFrame();
                cameraFrame.setVisible(true);
                dispose();
            }
        });
        contentPane.add(beautyCheckerButton);

        JButton beautyCompareButton = new JButton("Beauty Compare");
        beautyCompareButton.setBackground(new Color(147, 122, 219));
        beautyCompareButton.setBorder(null);
        beautyCompareButton.setForeground(Color.WHITE);
        beautyCompareButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        beautyCompareButton.setBounds(348, 152, 176, 34);
        beautyCompareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BeautyComparision beautyComparision = new BeautyComparision();
                beautyComparision.setVisible(true);
                dispose();
            }
        });
        contentPane.add(beautyCompareButton);

        JButton AccountInfoButton = new JButton("Account Info");
        AccountInfoButton.setBackground(new Color(212, 77, 3));
        AccountInfoButton.setBorder(null);
        AccountInfoButton.setForeground(Color.WHITE);
        AccountInfoButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        AccountInfoButton.setBounds(348, 213, 176, 34);
        AccountInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountInfo accountInfo = new AccountInfo();
                accountInfo.setVisible(true);
                dispose();
            }
        });
        contentPane.add(AccountInfoButton);

        JLabel imageLabel = new JLabel("");
        imageLabel.setIcon(new ImageIcon(Menu.class.getResource("/Images/MainMenu.jpg")));
        imageLabel.setBounds(37, 11, 210, 316);
        contentPane.add(imageLabel);

//        JLabel label = new JLabel("X");
//        label.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                dispose();
//            }
//
//        });
//        label.setHorizontalAlignment(SwingConstants.CENTER);
//        label.setForeground(Color.WHITE);
//        label.setFont(new Font("Century Gothic", Font.BOLD, 16));
//        label.setBounds(574, 11, 46, 14);
//        contentPane.add(label);
//
//        setUndecorated(true);
    }
}
