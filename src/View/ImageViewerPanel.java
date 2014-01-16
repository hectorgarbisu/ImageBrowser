package View;

import Model.Image;
import java.awt.Graphics;
import javax.swing.JPanel;
import Persisten.SwingBitmap;

/**
 *
 * @author osvaldo
 */
public class ImageViewerPanel extends JPanel implements ImageViewer {

    private Image image;

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image2) {
        image = image2;
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        if (image == null) {
            return;
        }
        super.paint(graphics);
        if (image.getBitMap() instanceof SwingBitmap) {
            graphics.drawImage(getBufferedImage((SwingBitmap) image.getBitMap()), 0, 0, null);
        }
    }

    private java.awt.Image getBufferedImage(SwingBitmap swingBitmap) {
        return swingBitmap.getBufferdImage();
    }
}
