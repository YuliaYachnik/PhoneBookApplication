package org;

import org.date.Data;
import org.services.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBookApplication {
    private List <CommandDefinition> commandDefinition;
    private Map<String,String> params;
    private Map <String,CommandDefinition> commandDefinitionMap;

    public PhoneBookApplication(List <CommandDefinition> commandDefinition, Map<String, String> params) {
        if(commandDefinition == null &&  params == null)
            throw new RuntimeException("No arguments in command line");
        else{
            this.commandDefinition = commandDefinition;
            this.params = params;
            commandDefinitionMap = new HashMap<>();
            for(int i = 0; i < commandDefinition.size(); i++) {
                commandDefinitionMap.put(commandDefinition.get(i).getName(), commandDefinition.get(i));
            }
        }
    }

    public void run(String args[]){
        try{
            String commandName = args[0];
            Command  command = commandDefinitionMap.get(commandName).getCommand().newInstance();
            Data data = new Data();
            CommandCheckImpl commandCheck = new CommandCheckImpl(this.commandDefinitionMap.get(commandName).getParametrDefinitions(),args);
            CheckManager checkManager = new CheckManager();
            command.execute(checkManager.returnValideObject(commandCheck));
        }catch (NullPointerException e){
            System.out.println("Such method no definite");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No paramentrs in command line");
        } catch (InstantiationException e) {
            System.out.println("Initializing parameters error");
        } catch (IllegalAccessException e) {
            System.out.println("Illegal access to class");
        }
    }
}
