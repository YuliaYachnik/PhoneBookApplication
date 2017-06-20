package org.services.checker;

import org.services.Command;
import org.services.CommandDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Юлия on 20.06.2017.
 */
public class CommandCheckDefinition {
    private Command command;
    private Class <Check> checkClass;
    private Map<Command,Class> commandCheckMap;

    public Class<Check> getCheckClass() {

            return checkClass= commandCheckMap.get(command);

    }

    public CommandCheckDefinition(Command command) {
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
        commandCheckMap.put(command,checkAdd);
        commandCheckMap.put(command,checkFind);
        commandCheckMap.put(command,checkList);
        commandCheckMap.put(command,checkHelp);

      //  checkClass = commandCheckMap.get(command).getClass().newInstance();
       return this;
    }

}
