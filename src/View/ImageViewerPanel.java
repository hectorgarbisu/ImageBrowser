package View;

import Model.Image;
import java.awt.Graphics;
import javax.swing.JPanel;
import Persisten.SwingBitmap;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ImageViewerPanel extends JPanel implements ImageViewer {

    private Image image;
    private int initialX;
    private int offset;
  

    public ImageViewerPanel() {
        offset = 0;
        this.hookEvents();
    }

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
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        if (image.getBitMap() instanceof SwingBitmap) {
            graphics.drawImage(getBufferedImage((SwingBitmap) image.getBitMap()), offset, 0, null);
            putImage(graphics);
        }

    }

    private java.awt.Image getBufferedImage(SwingBitmap swingBitmap) {
        return swingBitmap.getBufferdImage();
    }

    private void hookEvents() {
        hookMouseListener();
        hookMouseMotionListener();


    }

    private void hookMouseListener() {
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                initialX = e.getX();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (offset>-image.getBitMap().getWidth()/2 )
                    image=image.getPrev();
                
                if (offset<image.getBitMap().getWidth()/2 )
                    image=image.getNext();
                offset=0;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    private void hookMouseMotionListener() {
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                offset = e.getX() - initialX;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
    }

    private void putImage(Graphics graphics) {
        if (offset == 0) {
            return;
        }
        if (offset < 0) {
            graphics.drawImage(getBufferedImage((SwingBitmap) image.getNext().getBitMap()), 
                                                (int) (image.getBitMap().getWidth()+ offset), 
                                                0, null);
        } else {
            graphics.drawImage(getBufferedImage((SwingBitmap) image.getPrev().getBitMap()), 
                              (int) (offset-image.getBitMap().getWidth()), 
                               0, null);
        }
    }
}
