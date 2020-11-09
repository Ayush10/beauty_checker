package camera;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamResolution;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Camera {

    public static void main(String[] args) {
        Webcam webcam = Webcam.getDefault();

        webcam.addWebcamListener(new WebcamListener() {
            @Override
            public void webcamOpen(WebcamEvent webcamEvent) {
                System.out.println("Webcam open");
            }

            @Override
            public void webcamClosed(WebcamEvent webcamEvent) {
                System.out.println("Webcam closed");
            }

            @Override
            public void webcamDisposed(WebcamEvent webcamEvent) {
                System.out.println("Webcam disposed");
            }

            @Override
            public void webcamImageObtained(WebcamEvent webcamEvent) {
                System.out.println("Image Taken");
            }
        });

//        for (Dimension supportedSize: webcam.getViewSizes()) {
//            System.out.println(supportedSize.toString());
//        }
//        webcam.setViewSize(new Dimension(640, 480));
        webcam.setViewSize(WebcamResolution.VGA.getSize());
//        webcam.open();
//        ImageIO.write(webcam.getImage(), "JPG", new File('FirstCapture.jpg'));
//        webcam.close();
    }
}
