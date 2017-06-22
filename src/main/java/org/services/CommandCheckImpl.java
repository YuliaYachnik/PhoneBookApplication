package org.services;

import org.services.Check;
import org.services.ParametrDefinitions;
import org.services.add.checkAdd.CheckAddCommandReceiver;

import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 20.06.2017.
 */
public class CommandCheckImpl implements Check {
    private List<ParametrDefinitions> parametrDefinitions;
    private String[] commandArgumentsFromCommandLine;

    public CommandCheckImpl() {
    }

    public CommandCheckImpl(List<ParametrDefinitions> parametrDefinitions, String[] commandArgumentsFromCommandLine) {
        this.parametrDefinitions = parametrDefinitions;
        this.commandArgumentsFromCommandLine = commandArgumentsFromCommandLine;
    }

    @Override
    public boolean check(List<ParametrDefinitions> parametrDefinitions, String args[]) {
        /*try{
        String str[]  = checkAddCommandReceiver.checkAddCommand(parametrDefinitions,args);
        if(str != null) return str;
        else throw new RuntimeException();
        }catch (RuntimeException e){
            System.out.println("Command Add is not valid! Please, use help-manager");
            return null;
        }*/
        return true;
    }
}
