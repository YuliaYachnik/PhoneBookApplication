package org.services.checker;

import org.services.Command;
import org.services.CommandDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 20.06.2017.
 */
public class CommandCheckDefinition {
    private List <CommandDefinition> commandDefinition;
    private Command command;
    private Class <Check> checkClass;
    private Map<String,Class> commandCheckMap;

    public Class<Check> getCheckClass() {

            return checkClass= commandCheckMap.get(command);

    }

    public Map<String, Class> getCommandCheckMap() {
        return commandCheckMap;
    }

    public CommandCheckDefinition(Command command, String name, List<CommandDefinition > commandDefinition) {
        this.commandDefinition  = commandDefinition;
        this.command = command;
        try {
            initCheckClass();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
    public CommandCheckDefinition initCheckClass() throws IllegalAccessException, InstantiationException {
        Class checkAdd  = AddCommandCheckImpl.class;
        Class checkFind = FindCommandCheckImpl.class;
        Class checkList = ListCommandCheckImpl.class;
        Class checkHelp = HelpCommandCheckImpl.class;

        commandCheckMap = new HashMap<>();
        commandCheckMap.put(commandDefinition.get(0).getName(),checkAdd);
        commandCheckMap.put(commandDefinition.get(1).getName(),checkFind);
        commandCheckMap.put(commandDefinition.get(2).getName(),checkList);
        commandCheckMap.put(commandDefinition.get(3).getName(),checkHelp);

      //  checkClass = commandCheckMap.get(command).getClass().newInstance();
       return this;
    }

}
