package ImageBrowser;
/**
 * Authors:
 * Juan Daniel Cabrera Déniz
 * David Díaz González
 * Héctor Garbisu Arocha
 * Adrián Mujica González
 */
import Control.setTitleCommand;
import Control.DictionaryCommand;
import Control.NextImageCommand;
import Control.PrevImageCommand;
import Model.Image;
import Persisten.ImageLoaderFileList;
import View.ActionListenerFactory;
import View.AplicationFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Aplication {
 static  final String Path="C:\\Users\\Public\\Pictures\\Sample Pictures";
    public static void main(String[] args) {
        new Aplication().execute();
    }

    private void execute() {
        final DictionaryCommand setCommand = new DictionaryCommand();
        ImageLoaderFileList imageLoaderFileList=new ImageLoaderFileList(Path);
        List<Image>list= imageLoaderFileList.load();
        ActionListenerFactory actionListenerFactory = new ActionListenerFactory() {
            @Override
            public ActionListener create(final String name) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setCommand.get(name).execute();

                    }
                };
            }
        };
        AplicationFrame frame=new AplicationFrame(actionListenerFactory);
        frame.getImageViewer().setImage(list.get(0));
        setCommand.put("next", new NextImageCommand(frame.getImageViewer()));
        setCommand.put("prev", new PrevImageCommand(frame.getImageViewer()));
        setCommand.put("setTitle", new setTitleCommand(frame,frame.getImageViewer()));
        frame.setVisible(true);
    }
}
