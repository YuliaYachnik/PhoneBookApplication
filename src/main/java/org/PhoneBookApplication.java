package org;

import org.check.CheckManager;
import org.services.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

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
        try{
            String commandName = args[0];
            Command  command = commandDefinitionMap.get(commandName).getCommand().newInstance();
            CommandCheckImpl commandCheck = new CommandCheckImpl(this.commandDefinitionMap.get(commandName).getParametrDefinitions(),params,args);
            CheckManager checkManager = new CheckManager(commandCheck);
            command.execute(checkManager.returnValidateObject());
        }catch (NullPointerException e){
            System.out.println("Such method no definite");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No paramentrs in command line");
        }catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }catch (DataFormatException e){
            System.out.println("Uncorrect data format of parametrs");
        }catch (IOException e) {
            System.out.println("Exception with fileworking!");
        } catch (InstantiationException e) {
            System.out.println("Initializing parameters error");
        } catch (IllegalAccessException e) {
            System.out.println("Illegal access to class");
        } catch (RuntimeException e){
            System.out.println("Error with command line parametrs. Please, use help-manager.");
        }  catch (Exception e) {
            System.out.println("Please, use help-manager.");
        }
    }
}
