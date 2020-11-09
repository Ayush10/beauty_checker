package camera;

import checker.BeautyScore;
import checker.BeautyScores;
import com.github.sarxos.webcam.Webcam;
import com.sun.istack.internal.logging.Logger;
import main.Menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CameraFrame extends JFrame {

    private JPanel contentPane;
    private JPanel camera;
    private JLabel imageHolder;
    Boolean isRunning = false;

    Webcam webcam;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    CameraFrame frame = new CameraFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CameraFrame() {
        setBackground(Color.WHITE);
        setFont(new Font("Dialog", Font.BOLD, 16));
        setTitle("Beauty Check");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(UIManager.getColor("Button.background"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton backButton = new JButton("Back");
        backButton.setBorder(null);
        backButton.setBackground(new Color(196, 196, 196));
        backButton.setForeground(new Color(147, 122, 219));
        backButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        backButton.setBounds(5, 489, 89, 23);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                menu.setVisible(true);
                dispose();
            }
        });
        contentPane.add(backButton);

//        camera = new JPanel();
//        camera.setBackground(Color.WHITE);
//        camera.setBounds(0, 0, 782, 464);
//        contentPane.add(camera);

        imageHolder = new JLabel();
        imageHolder.setBackground(Color.WHITE);
        imageHolder.setBounds(0, 0, 782, 464);
        contentPane.add(imageHolder);

        JButton startButton = new JButton("Start");
        startButton.setForeground(Color.WHITE);
        startButton.setBackground(new Color(72, 209, 204));
        startButton.setBounds(100, 489, 137, 38);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCamera();
            }
        });
        contentPane.add(startButton);

        JButton captureButton = new JButton("Capture");
        captureButton.setForeground(Color.WHITE);
        captureButton.setBackground(new Color(72, 209, 204));
        captureButton.setBounds(332, 489, 137, 38);
        captureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < 5; i++) {
                        ImageIO.write(webcam.getImage(), "JPG", new File("E:\\Finallllllll\\src\\captured_images\\firstCapture" + i + ".jpg"));
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                webcam.close();
            }
        });
        contentPane.add(captureButton);

        JButton checkButton = new JButton("Check");
        checkButton.setForeground(Color.WHITE);
        checkButton.setBackground(new Color(64, 224, 208));
        checkButton.setBounds(545, 489, 137, 38);
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                checkBeauty();
                BeautyScores beautyScores = new BeautyScores();
                beautyScores.setVisible(true);
                dispose();
            }
        });
        contentPane.add(checkButton);
    }

//    private void checkBeauty() {
//        webcam.close();
//    }

    class VideoFeedTaker extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Image image = webcam.getImage();
                    imageHolder.setIcon(new ImageIcon(image));
                    Thread.sleep(20); // waits 20ms to take image
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }



    private void startCamera() {
        webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));
        webcam.open();

        new VideoFeedTaker().start();

    }


}
