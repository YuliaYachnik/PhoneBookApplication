package org.services.help;

import org.services.Command;

/**
 * Created by Юлия on 16.06.2017.
 */
public class HelpCommandImpl implements Command {
    private CommandDefinitionToHelp commandDefinitionToHelp;

    public HelpCommandImpl(CommandDefinitionToHelp commandDefinitionToHelp) {
        this.commandDefinitionToHelp = commandDefinitionToHelp;
    }

    public HelpCommandImpl(){}

    public void execute() {
        commandDefinitionToHelp = new CommandHelpDefinitionToHelp().executeHelp() ;
        System.exit(0);
    }
}
