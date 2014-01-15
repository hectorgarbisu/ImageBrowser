package ImageBrowser;

import Control.DictionaryCommand;
import Control.NextImageCommand;
import View.ActionListenerFactory;
import View.AplicationFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplication {

    public static void main(String[] args) {
        new Aplication().execute();
    }

    private void execute() {
        final DictionaryCommand setCommand = new DictionaryCommand();
        
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
        setCommand.put("next", new NextImageCommand(null));
    }
}
