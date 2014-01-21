package Control;

import Control.Command;
import View.AplicationFrame;
import View.ImageViewer;

public class setTitleCommand implements Command {

    ImageViewer imageViewer;
    AplicationFrame frame;
    
    public setTitleCommand(AplicationFrame frame, ImageViewer imageViewer) {
        this.imageViewer = imageViewer;
        this.frame = frame;
    }

    @Override
    public void execute() {
        frame.setTitle(imageViewer.getImage().getTitle()+ " - Image Viewer");
    }
    
}
