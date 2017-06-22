package org.services.help;

import org.services.Check;
import org.services.ParametrDefinitions;

import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 21.06.2017.
 */
public class HelpCommandCheckImpl implements Check {
    private CheckHelpCommandReceiver checkHelpCommandReceiver;

    public HelpCommandCheckImpl() {
        this.checkHelpCommandReceiver = new CheckHelpCommandReceiver();
    }

    @Override
    public String[] check( Map<String,String> map, String args[]) {
        this.checkHelpCommandReceiver.checkHelpCommand();
        return args;

    }
}
