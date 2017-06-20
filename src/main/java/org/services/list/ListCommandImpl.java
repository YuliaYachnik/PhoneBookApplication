package org.services.list;

import org.parsing.ParseArguments;
import org.services.Command;
import org.services.help.CommandDefinitionToHelp;
import org.services.help.CommandListDefinitionToHelp;

import java.awt.*;

/**
 * Created by Юлия on 16.06.2017.
 */
public class ListCommandImpl implements Command{
    private CommandListDefinition commandListDefinition;
    private ParseArguments parseArguments;

    public ListCommandImpl(CommandListDefinition commandListDefinition, ParseArguments parseArguments){
        this.commandListDefinition = commandListDefinition;
        this.parseArguments = parseArguments;
    }

    public ListCommandImpl(){}

    public void execute() {
        if(parseArguments != null) commandListDefinition.list(parseArguments);
    }
}
