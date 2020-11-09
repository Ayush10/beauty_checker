package camera;

//import com.googlecode.javacv.CanvasFrame;
//import com.googlecode.javacv.FrameGrabber;
//import com.googlecode.javacv.OpenCVFrameGrabber;
//import com.googlecode.javacv.cpp.opencv_core;
//import com.googlecode.javacv.cpp.opencv_highgui;
import database.SQLConnection;
//import frame.Frame;
//import org.bytedeco.javacpp.BytePointer;
//import org.bytedeco.opencv.global.opencv_imgproc;
//import org.bytedeco.opencv.opencv_core.*;
//import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
//import org.bytedeco.opencv.opencv_videoio.VideoCapture;
//import org.opencv.core.Size;

//import org.bytedeco.opencv.opencv_core.Mat;

import javax.swing.*;
//import org.bytedeco.javacpp.BytePointer;
//import static org.bytedeco.opencv.global.opencv_imgcodecs.imencode;
//import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
//import org.bytedeco.opencv.global.opencv_imgproc;
//import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
//import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
//import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
//import org.bytedeco.opencv.opencv_core.Mat;
//import org.bytedeco.opencv.opencv_core.Rect;
//import org.bytedeco.opencv.opencv_core.RectVector;
//import org.bytedeco.opencv.opencv_core.Scalar;
//import org.bytedeco.opencv.opencv_core.Size;
//import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
//import org.bytedeco.opencv.opencv_videoio.VideoCapture;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import org.bytedeco.javacpp.BytePointer;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imencode;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import org.bytedeco.opencv.global.opencv_imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import java.sql.Connection;

//import static org.bytedeco.opencv.global.opencv_imgcodecs.imencode;
//import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
//import static org.bytedeco.opencv.global.opencv_imgproc.*;

public class Capture extends JFrame {

    private JPanel contentPane;
    private Capture.DaemonThread myThread = null;
    private JPanel camera;

    // JavaCV
    VideoCapture webSource = null;
    Mat cameraImage = new Mat();
    CascadeClassifier cascadeClassifier = new CascadeClassifier("E:\\Finallllllll\\src\\haarcascades\\haarcascade_frontalface_alt.xml");

    BytePointer bytePointer = new BytePointer();
    RectVector detectedFaces = new RectVector();

    int numSamples = 25, sample = 1, idPerson;

    SQLConnection connection = new SQLConnection();

//    public Capture() {
////        super(parent, model);
//        getIdUser();
//        startCamera();
//    }


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Capture frame = new Capture();
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
    public Capture() {
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

        camera = new JPanel();
        camera.setBackground(Color.WHITE);
        camera.setBounds(0, 0, 782, 464);
        contentPane.add(camera);

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

        JButton stopButton = new JButton("Stop");
        stopButton.setForeground(Color.WHITE);
        stopButton.setBackground(new Color(64, 224, 208));
        stopButton.setBounds(545, 489, 137, 38);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopCamera();
            }
        });
        contentPane.add(stopButton);
    }

    class DaemonThread implements Runnable {
        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    try {
                        if (webSource.grab()) {
                            webSource.retrieve(cameraImage);
                            Graphics g = camera.getGraphics(); // set image in the JPanel

                            Mat imageColor = new Mat(); // image colors
                            imageColor = cameraImage;

                            Mat imageGray = new Mat(); // image pb
                            cvtColor(imageColor, imageGray, COLOR_BGRA2GRAY);
//                            flip(cameraImage, cameraImage, +1);

                            RectVector detectedFaces = new RectVector(); // face dectection
                            cascadeClassifier.detectMultiScale(imageColor, detectedFaces, 1.1, 1, 1, new Size(300, 300), new Size(500, 500));

                            for (int i = 0; i < detectedFaces.size(); i++) { // repetition to find faces
                                Rect faceData = detectedFaces.get(0);

                                rectangle(imageColor, faceData, new Scalar(255, 255, 0, 2), 3, 0, 0);

                                Mat face = new Mat(imageGray, faceData);
                                opencv_imgproc.resize(face, face, new org.bytedeco.opencv.opencv_core.Size(160, 160));

                                if (sample <= numSamples) {
                                    // save the cropped image [160,160]
                                    // file name: person + photo count. ex: person.10 (id) .6 (sixth photo) .jpg
                                    String cropped = "/captured_images/person." + idPerson + "." + sample + ".jpg";
                                    imwrite(cropped, face);

//                                    System.out.println("Photo and sample captured");
                                    sample++;
                                }
                                if (sample > 25) {
                                    new TrainLBPH().trainPhotos(); // if the count is greater than 25, finish taking the photo, generate the file
//                                    insertDatabase(); // insert the data in the database

                                    System.out.println("File Generated");
                                    stopCamera();
                                }
                            }
                            imencode(".bmp", cameraImage, bytePointer);
                            Image image = ImageIO.read(new ByteArrayInputStream(bytePointer.getStringBytes()));
                            BufferedImage bufferedImage = (BufferedImage) image;
                            try {
                                if (g.drawImage(bufferedImage, 0, 0, 360, 390, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null)) {
                                    if (runnable == false) {
                                        System.out.println("Save Photo");
                                        this.wait();
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

        }
    }

    private void stopCamera() {
        myThread.runnable = false;
        webSource.release();
        dispose();

    }

    private void startCamera() {
        new Thread(() -> {
            webSource = new VideoCapture(0);

            myThread = new Capture.DaemonThread();
            Thread t = new Thread(myThread);
            t.setDaemon(true);
            myThread.runnable = true;
            t.start();
        }).start();
    }
}
