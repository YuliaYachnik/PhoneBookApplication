package org.services.help;

import org.services.Command;

/**
 * Created by Юлия on 16.06.2017.
 */
public class HelpCommandImpl implements Command {
    private AbstractHelpCommandReceiver abstractHelpCommandReceiver;

    public HelpCommandImpl(AbstractHelpCommandReceiver abstractHelpCommandReceiver) {
        this.abstractHelpCommandReceiver = abstractHelpCommandReceiver;
    }

    public HelpCommandImpl(){}

    public void execute() {
        abstractHelpCommandReceiver = new CommandHelpDefinitionToHelp().executeHelp();
        System.exit(0);
    }
}
