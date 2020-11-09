package checker;

import loginandregister.Login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Random;

public class BeautyScore extends JFrame{

    JTable table, scoreTable;
    JPanel contentPane;
    DefaultTableModel defaultTableModel, anotherTableModel;
    JScrollPane scrollPane;
    Random random;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    BeautyScore frame = new BeautyScore();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BeautyScore() {
        setBounds(100, 100, 800, 600);
        setBackground(Color.WHITE);
        setFont(new Font("Dialog", Font.BOLD, 16));
        setTitle("Beauty Check");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(UIManager.getColor("Button.background"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel imageLabel = new JLabel("");
        imageLabel.setIcon(new ImageIcon(Login.class.getResource("/captured_images/firstCapture0.jpg")));
        imageLabel.setBounds(0, 0, getWidth(), getHeight());
        contentPane.add(imageLabel);

        table = new JTable();
        Object[] columns = {"Eyes", "Nose", "Lips", "Average Score"};
        defaultTableModel = new DefaultTableModel();

//        scoreTable = new JTable();
//        Object[] newColumn = {"Average Score"};
//        anotherTableModel = new DefaultTableModel();
//        anotherTableModel.setColumnIdentifiers(columns);


        defaultTableModel.setColumnIdentifiers(columns);
        table.setSize(400, 400);
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
        scrollPane.setForeground(Color.RED);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBounds(10, 10, 10, 10);
        contentPane.add(scrollPane);

        random = new Random();
        int low = 60;
        int high = 100;

        int eyes = random.nextInt(high - low) + low;
        int nose = random.nextInt(high - low) + low;
        int lips = random.nextInt(high - low) + low;
        int average = (int)((eyes + nose + lips) / 3);

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
//
////        defaultTableModel.insertRow(0, new Object[][] {"Eyes"}{eyes});
////        defaultTableModel.insertRow(0, new Object[] {eyes});
//
//        Object[] row1 = new Object[2];
//        row[1] = "Nose";
//        row[1] = nose;
//        defaultTableModel.addRow(row1);
//
//        Object[] row2 = new Object[2];
//        row[2] = "Lips";
//        row[1] = lips;
//        defaultTableModel.addRow(row2);
//
//        Object[] row3 = new Object[2];
//        row[3] = "Total Score";
//        row[1] = (int) ((eyes + nose + lips) / 3);
//        defaultTableModel.addRow(row3);

        Object[] row = new Object[4];
        row[0] = eyes;
        row[1] = nose;
        row[2] = lips;
        row[3] = average;
        defaultTableModel.addRow(row);

//        Object[] anotherRow = new Object[];
//        row[0] = average;
//        anotherTableModel.addRow(anotherRow);

//        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
//        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
//        for (int i = 0; i < 5; i++) {
//            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
//        }
    }
}
