package org.services.help;

import org.services.Command;

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

    public void execute() {
        if(helpCommandCheck.check(args) != null)
        abstractHelpCommandReceiver = new CommandHelpDefinitionToHelp().executeHelp();
        System.exit(0);
    }
}
