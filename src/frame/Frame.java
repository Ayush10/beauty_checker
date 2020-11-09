package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

public class Frame {

    GraphicsDevice graphicsDevice;
    JFrame window;
    int currentScreenHeight, currentScreenWidth;
    boolean fullScreenSize = false;
    Container container;

    public Frame() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
        window = new JFrame();
//        currentScreenWidth = 800;
//        currentScreenHeight = 600;
        window.setLocation(400, 200);
        window.setSize(currentScreenWidth = 800, currentScreenHeight = 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(new Color(235, 235, 235));
        container = window.getContentPane();
        window.setLayout(null);
        fullScreenSize = false;
        window.setVisible(true);
    }

    private void setFullScreen() {
        graphicsDevice.setFullScreenWindow(window);

        currentScreenWidth = window.getWidth();
        currentScreenHeight = window.getHeight();
    }

    public void endFullScreen() {
        window.dispose();
        graphicsDevice.setFullScreenWindow(null);

        currentScreenWidth = 800;
        currentScreenHeight = 600;
    }

    public class FullScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (fullScreenSize == false) {
                fullScreenSize = true;
                setFullScreen();
            } else {
                fullScreenSize = false;
                endFullScreen();
            }
        }
    }

    public JLabel closeButton() {
        JLabel exitButton = new JLabel("X");
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exitButton.setHorizontalAlignment(SwingConstants.CENTER);
        exitButton.setFont(new Font("Century Gothic", Font.BOLD, 22));
        exitButton.setForeground(Color.BLACK);
        exitButton.setBounds(1020, 20, 46, 30);
        return exitButton;
    }

    public JButton doneButton() {
        JButton done = new JButton("Done");
        done.setForeground(Color.WHITE);
        done.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        done.setBorder(null);
        done.setBackground(new Color(147, 112, 219));
        return done;
    }

}
