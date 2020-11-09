package mischelleneous;

import javax.swing.*;

public class MenuBarImplementation {

    public static void main(String[] args) {
        JFrame frame = new JFrame("MenuBar Example");
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");



        frame.setVisible(true);
    }
}
