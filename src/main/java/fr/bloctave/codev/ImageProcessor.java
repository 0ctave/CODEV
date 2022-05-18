package fr.bloctave.codev;


import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.awt.image.ColorConvertOp;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class ImageProcessor {

    private LinkedList<BufferedImage> dataStream;

    public ImageProcessor() {
        dataStream = new LinkedList<>();
    }


    public List<BufferedImage> getDataStream() {
        return dataStream;
    }

    public void pushImage(BufferedImage bufferedImage) {
        //ColorConvertOp filter = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        //bufferedImage = filter.filter(bufferedImage, null);
        dataStream.add(bufferedImage);
        //Stream.concat(dataStream, Stream.of(bufferedImage));
    }

    public BufferedImage popImage() {
        return dataStream.removeFirst();
    }


}
