package fr.bloctave.codev;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class Main {

    private static Main instance;
    private ImageProcessor imageProcessor;


    public Main() {
        instance = this;
        imageProcessor = new ImageProcessor();

        Webcam webcam = Webcam.getDefault();
        webcam.setCustomViewSizes(new Dimension[] { WebcamResolution.HD720.getSize() }); // register custom size
        webcam.setViewSize(WebcamResolution.HD720.getSize()); // set size
        webcam.open();

        new CameraThread(webcam).start();
        new DisplayThread(webcam.getImage()).start();
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    public static Main getInstance() {
        return instance;
    }

    public ImageProcessor getImageProcessor() {
        return imageProcessor;
    }
}
