package Control;

import java.util.HashMap;

public class DictionaryCommand {

    HashMap<String,Command>setcommand;

    public DictionaryCommand(HashMap<String, Command> setcommand) {
        this.setcommand = setcommand;
    }

    public DictionaryCommand() {
        setcommand=new HashMap<>();
    }

    public Command get(String key) {
        return setcommand.get(key);
    }

    public Command put(String key, Command value) {
        return setcommand.put(key, value);
    }
    
}
