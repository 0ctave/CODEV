package fr.bloctave.codev;

import com.github.sarxos.webcam.Webcam;

import java.awt.image.BufferedImage;
import java.util.stream.Collectors;

public class CameraThread extends Thread {
    private final Webcam webcam;
    private BufferedImage bufferedImage = null;
    public CameraThread(Webcam webcam) {
        super();
        this.webcam = webcam;
        //ImageIO.write(webcam.getImage(), "PNG", new File("hello-world.png"));
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            if (webcam.getImage() != bufferedImage) {
                bufferedImage = webcam.getImage();
                Main.getInstance().getImageProcessor().pushImage(bufferedImage);
            }
        }
    }


}
