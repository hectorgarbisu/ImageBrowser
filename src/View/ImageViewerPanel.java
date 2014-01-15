package View;

import Model.Image;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author osvaldo
 */
public class ImageViewerPanel extends JPanel implements ImageViewer {

    Image image;

    public ImageViewerPanel(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image2) {
        image = image2;
    }
   
    @Override
    public void paint(Graphics graphics) {
    
    }
}
