package org.services;

import org.check.Check;

import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 20.06.2017.
 */
public class CommandCheckImpl implements Check {
    private List<ParametrDefinitions> parametrDefinitions;
    private Map<String,String> optionalParams;
    private String[] commandArgumentsFromCommandLine;

    public CommandCheckImpl() {}

    public CommandCheckImpl(List<ParametrDefinitions> parametrDefinitions, Map<String,String> optionalParams, String[] commandArgumentsFromCommandLine) {
        this.parametrDefinitions = parametrDefinitions;
        this.optionalParams = optionalParams;
        this.commandArgumentsFromCommandLine = commandArgumentsFromCommandLine;
    }

    public List<ParametrDefinitions> getParametrDefinitions() {
        return parametrDefinitions;
    }

    public String[] getCommandArgumentsFromCommandLine() {
        return commandArgumentsFromCommandLine;
    }

    public Map<String, String> getOptionalParams() {
        return optionalParams;
    }

    @Override
    public boolean check(List<ParametrDefinitions> parametrDefinitions,Map<String,String> optionalParams, String args[]) {
            if (parametrDefinitions == null || args == null || optionalParams == null || args.length > 5){
                throw new NullPointerException("Parametrs are not valid! Please, use help-manager");
            } else{
               if( chooseVersionOfParsing(getNameOfMethod())== true) return true;
                return false;
            }
    }

    public boolean checkMatchingOptionalAndArgsParametrInAdd(){
       if((getCommandArgumentsFromCommandLine().length == getMandatryArguments() + 1) && getOptionalParams() == null)
           return false;
       if((getCommandArgumentsFromCommandLine().length ==  getMandatryArguments() + 2 )&& getOptionalParams() == null)
           return false;
       if(getCommandArgumentsFromCommandLine().length >= getMandatryArguments() + 1)
           return true;
        else return false;
    }

   public boolean checkMatchingOptionalAndArgsParametrInFind(){
        if((getCommandArgumentsFromCommandLine().length == getMandatryArguments() + 1) && getOptionalParams() == null)
            return false;
        if(getCommandArgumentsFromCommandLine().length ==  getMandatryArguments() + 2 && getOptionalParams() == null)
            return false;
        if((getCommandArgumentsFromCommandLine().length >=  getMandatryArguments() + 1) && getCommandArgumentsFromCommandLine().length < 5)
            return true;
        else return false;
   }

   public boolean checkMatchingOptionalAndArgsParametrInList(){
       if(getCommandArgumentsFromCommandLine().length == 1 && getOptionalParams() == null) return false;
       if(getCommandArgumentsFromCommandLine().length == 2 && getOptionalParams() == null) return false;
       if(getCommandArgumentsFromCommandLine().length < 4 ) return true;
       else return false;
   }

   public  boolean checkMatchingOptionalAndArgsParametrInHelp(){
       if(getCommandArgumentsFromCommandLine().length == 1) return true;
       else return false;
   }
    public  int getMandatryArguments(){
        int mandatoryCount = 0;
        for(int i = 0; i < getParametrDefinitions().size(); i++){
            if(getParametrDefinitions().get(i).isMandatory() == true)  mandatoryCount++;
        }
        if(mandatoryCount != 0)
            return mandatoryCount;
        else
            throw new RuntimeException("Initializing parameters error. Please, use help-manager.");
    }

    public String getNameOfMethod(){
        String name = getCommandArgumentsFromCommandLine()[0];
        return name;
    }

    private  boolean chooseVersionOfParsing(String nameOfMethod){
        if(nameOfMethod.equals("add")) return checkMatchingOptionalAndArgsParametrInAdd();
        if(nameOfMethod.equals("find")) return checkMatchingOptionalAndArgsParametrInFind();
        if(nameOfMethod.equals("list"))return checkMatchingOptionalAndArgsParametrInList();
        else return checkMatchingOptionalAndArgsParametrInHelp();
    }
}
