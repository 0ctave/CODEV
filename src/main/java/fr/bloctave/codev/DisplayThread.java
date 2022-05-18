package fr.bloctave.codev;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DisplayThread extends Thread {

    private JFrame frame;
    private JLabel label;
    public DisplayThread(BufferedImage image) {
        super();
        frame=new JFrame();
        frame.setTitle("stained_image");
        frame.setSize(image.getWidth(), image.getHeight());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        label=new JLabel();
        label.setIcon(new ImageIcon(image));
        frame.getContentPane().add(label,  BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void run() {
        super.run();
        for (;;) {
            if (Main.getInstance().getImageProcessor().getDataStream().size() > 1) {
                display(Main.getInstance().getImageProcessor().popImage());
            }else {
                System.out.println("d");
            }
        }
    }

    public void display(BufferedImage image) {
        label.setIcon(new ImageIcon(image));
    }
}
