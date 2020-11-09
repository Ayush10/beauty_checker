package checker;

import camera.CameraFrame;
import main.Intro;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BeautyScores extends JFrame{
    private JPanel contentPane;
    JTable table, scoreTable;
    DefaultTableModel defaultTableModel, anotherTableModel;
    JScrollPane scrollPane;
    Random random;
    JLabel imageLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BeautyScores frame = new BeautyScores();
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
    public BeautyScores() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

//		JLabel imageLabel = new JLabel("");
//        imageLabel.setIcon(new ImageIcon(Login.class.getResource("/captured_images/firstCapture.jpg")));
//        imageLabel.setBounds(0, 0, getWidth(), getHeight());
//        contentPane.add(imageLabel);

        JButton backButton = new JButton("Back");
        backButton.setBorder(null);
        backButton.setBackground(new Color(196, 196, 196));
        backButton.setForeground(new Color(147, 122, 219));
        backButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        backButton.setBounds(100, 100, 89, 23);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CameraFrame cameraFrame = new CameraFrame();
                cameraFrame.setVisible(true);
                dispose();
            }
        });
        contentPane.add(backButton);

        table = new JTable();
        Object[] columns = {"Eyes", "Nose", "Lips", "Average Score"};
        defaultTableModel = new DefaultTableModel();

        defaultTableModel.setColumnIdentifiers(columns);
        contentPane.setLayout(null);
//        table.setSize(400, 400);
        table.setModel(defaultTableModel);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(Color.red);
        table.setGridColor(Color.red);
        table.setSelectionForeground(Color.white);
        table.setFont(new Font("Tahome", Font.PLAIN, 22));
        table.setRowHeight(50);
        table.setAutoCreateRowSorter(true);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 410, 82);
        scrollPane.setForeground(Color.RED);
        scrollPane.setBackground(Color.WHITE);
        contentPane.add(scrollPane);

//        scoreTable = new JTable();
//        Object[] newColumn = {"Average Score"};
//        anotherTableModel = new DefaultTableModel();
//        anotherTableModel.setColumnIdentifiers(columns);

        random = new Random();
        int low = 60;
        int high = 100;

        int eyes = random.nextInt(high - low) + low;
        int nose = random.nextInt(high - low) + low;
        int lips = random.nextInt(high - low) + low;
        int average = (int)((eyes + nose + lips) / 3);

//        Object[] row = new Object[2];
//        row[0] = "Eyes";
//        row[1] = eyes;
//        defaultTableModel.addRow(row);
//
//        Object[] row1 = new Object[2];
//        row1[0] = "Nose";
//        row1[0] = nose;
//        defaultTableModel.addRow(row1);
//
//        Object[] row2 = new Object[2];
//        row1[0] = "Lips";
//        row1[1] = lips;
//        defaultTableModel.addRow(row2);
//
//        Object[] row3 = new Object[2];
//        row1[0] = "Total Score";
//        row1[1] = (int) ((eyes + nose + lips) / 3);
//        defaultTableModel.addRow(row3);
//        defaultTableModel.insertRow(0, new Object[] {"Eyes"});
//        defaultTableModel.insertRow(1, new Object[] {eyes});
//        defaultTableModel.insertRow(0, new Object[] {"Eyes"});
//        defaultTableModel.insertRow(1, new Object[] {eyes});
//        defaultTableModel.insertRow(0, new Object[] {"Eyes"});
//        defaultTableModel.insertRow(1, new Object[] {eyes});
//        defaultTableModel.insertRow(0, new Object[] {"Eyes"});
//        defaultTableModel.insertRow(1, new Object[] {eyes});
//        Object[][] row = new Object[4][4];
//        row[0][0] = "Eyes";
//        row[0][1] = eyes;
//        row[1][0] = "Nose";
//        row[1][1] = nose;
//        row[2][0] = "Lips";
//        row[2][1] = lips;
//        row[3][0] = "Total Score";
//        row[3][1] = (int) ((eyes + nose + lips) / 3);
//        defaultTableModel.addRow(row);



        Object[] row = new Object[4];
        row[0] = eyes;
        row[1] = nose;
        row[2] = lips;
        row[3] = average;
        defaultTableModel.addRow(row);

//        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
//        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
//        for (int i = 0; i <= 5; i++) {
//            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
//        }



//        Object[] anotherRow = new Object[1];
//        row[0] = average;
//        anotherTableModel.addRow(anotherRow);
    }
}
