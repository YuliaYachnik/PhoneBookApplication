package org.services;

import org.date.Data;

import java.util.List;

/**
 * Created by Юлия on 23.06.2017.
 */
public class CheckManager {
    Data data;

    public Data returnValideObject(CommandCheckImpl commandCheck){
        String stringArgsCheck[] = commandCheck.getCommandArgumentsFromCommandLine();
        List<ParametrDefinitions> parametrDefinitionsList = commandCheck.getParametrDefinitions();
        if(commandCheck.check(parametrDefinitionsList,stringArgsCheck) == true){
            //записать args в дату
            return data;
        }else throw new RuntimeException("Error with command line parametrs. Please, use help-manager.");
    }
}
