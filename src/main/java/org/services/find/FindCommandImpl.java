package org.services.find;

import org.parsing.ParseArguments;
import org.services.Command;
import org.services.help.CommandDefinitionToHelp;
import org.services.help.CommandFindDefinitionToHelp;

/**
 * Created by Юлия on 16.06.2017.
 */
public class FindCommandImpl implements Command {
    private CommandFindDefinition commandFindDefinition;
    private ParseArguments parseArguments;

    public FindCommandImpl(CommandFindDefinition commandFindDefinition, ParseArguments parseArguments) {
        this.commandFindDefinition = commandFindDefinition;
        this.parseArguments = parseArguments;
    }
    public FindCommandImpl(){}

    public void execute() {
        if(parseArguments != null) commandFindDefinition.find(parseArguments);

    }
}
