package Persisten;

import Model.RealImage;
import Persisten.Interface.ImageLoader;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoaderFile implements ImageLoader {

    private String fileName;

    public ImageLoaderFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public RealImage load() {
        RealImage realImage = new RealImage(new SwingBitmap(loadImage()));
        realImage.setTitle(fileName);
        return realImage;
    }

    private BufferedImage loadImage() {
        try {
            return ImageIO.read(new File(fileName));
        } catch (IOException ex) {
            return null;
        }
    }
}
