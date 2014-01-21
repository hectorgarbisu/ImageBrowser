package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class AplicationFrame extends JFrame {

    private ActionListenerFactory actionListenerFactory;
    private ImageViewer imageViewer;

    public AplicationFrame(ActionListenerFactory actionListenerFactory) {
        super("Image Viwer");
        this.actionListenerFactory = actionListenerFactory;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1024, 768));
        this.setLocationRelativeTo(null);
        createComponent();
       // this.setVisible(true);
    }

    public ActionListenerFactory getActionListenerFactory() {
        return actionListenerFactory;
    }

    public ImageViewer getImageViewer() {
        return imageViewer;
    }

    private void createComponent() {
        this.add(cretePanel());
        this.add(createToolBar(), BorderLayout.SOUTH);
    }

    private JPanel cretePanel() {
        imageViewer=new ImageViewerPanel();
        return (JPanel) imageViewer;
    }

    private JPanel createToolBar() {
        JPanel toolbar = new JPanel();
        toolbar.add(createPrev(), BorderLayout.SOUTH);
        toolbar.add(createNext(), BorderLayout.SOUTH);
        return toolbar;
    }

    private JButton createPrev() {
        JButton jButton = new JButton("Prev");
        jButton.addActionListener(actionListenerFactory.create("prev") );
        return jButton;
    }

    private JButton createNext() {
        JButton jButton = new JButton("Next");
        jButton.addActionListener(actionListenerFactory.create("next") );
        return jButton;
    }
}
