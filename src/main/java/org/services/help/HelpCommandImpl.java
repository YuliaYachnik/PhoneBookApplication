package org.services.help;

import org.date.Data;
import org.services.CheckManager;
import org.services.Command;
import org.services.CommandDefinition;

import java.util.Map;

/**
 * Created by Юлия on 16.06.2017.
 */
public class HelpCommandImpl implements Command {
    private AbstractHelpCommandReceiver abstractHelpCommandReceiver;
    private HelpCommandCheckImpl helpCommandCheck;
    String args[];

    public HelpCommandImpl(AbstractHelpCommandReceiver abstractHelpCommandReceiver) {
        this.abstractHelpCommandReceiver = abstractHelpCommandReceiver;
        this.helpCommandCheck = new HelpCommandCheckImpl();
    }

    public HelpCommandImpl(){}

    public void execute(Data data) {
      /*  helpCommandCheck.check(map,args);
        abstractHelpCommandReceiver = new CommandHelpDefinitionToHelp().executeHelp();
        System.exit(0);*/
    }
}
