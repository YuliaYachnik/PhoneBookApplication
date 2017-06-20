package org;

import org.services.Command;

import org.services.checker.Check;
import org.services.checker.CommandCheckDefinition;
import org.services.CommandDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBookApplication {
    private List <CommandDefinition> commandDefinition;
    private Map<String,String> params;
    private Map <String,CommandDefinition> commandDefinitionMap;

    public PhoneBookApplication(List <CommandDefinition> commandDefinition, Map<String, String> params) {
        this.commandDefinition = commandDefinition;
        this.params = params;
        commandDefinitionMap = new HashMap<>();
        for(int i = 0; i < commandDefinition.size(); i++) {
            commandDefinitionMap.put(commandDefinition.get(i).getName(), commandDefinition.get(i));
        }
    }

    public void run(String args[]){
        String commandName = args[0];
        CommandCheckDefinition commandCheckDefinition;
        try{
            Command  command = commandDefinitionMap.get(commandName).getCommand().newInstance();
            commandCheckDefinition = new CommandCheckDefinition(command);
            Check check  = commandCheckDefinition.getCheckClass().newInstance();
            check.check();
            command.execute();

        }catch (NullPointerException e){
            System.out.println("Such method no definite");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
