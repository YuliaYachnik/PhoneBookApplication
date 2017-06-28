package org;

import org.services.CommandDefinition;
import org.services.ParametrDefinitions;
import org.services.add.AddCommandImpl;
import org.services.find.FindCommandImpl;
import org.services.help.HelpCommandImpl;
import org.services.list.ListCommandImpl;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Юлия on 19.06.2017.
 */
public class ApplicationEntryPoint {
    public static void main(String args[]) throws ClassNotFoundException {

        ParametrDefinitions nameParametrDefinitions = new ParametrDefinitions("name",true);
        ParametrDefinitions phoneParametrDefinitions = new ParametrDefinitions("phone",true);
        ParametrDefinitions fileParametrDefinitions = new ParametrDefinitions("filename", false);
        ParametrDefinitions dirParametrDefinitions = new ParametrDefinitions("dirname",false);

        List <ParametrDefinitions> addParametrDefinitionsList = Arrays.asList(nameParametrDefinitions,phoneParametrDefinitions,fileParametrDefinitions,dirParametrDefinitions);
        List <ParametrDefinitions> findParametrDefinitionsList = Arrays.asList(nameParametrDefinitions,fileParametrDefinitions,dirParametrDefinitions);
        List <ParametrDefinitions> listParametrDefinitionsList = Arrays.asList(fileParametrDefinitions,dirParametrDefinitions);
        List <ParametrDefinitions> helpParametrDefinitionsList = new ArrayList<>();

        Map<String,String>  matchOptionalParametrsWithDefaultValue = new HashMap<>();
        matchOptionalParametrsWithDefaultValue.put("--filename","phonebook.txt");
        matchOptionalParametrsWithDefaultValue.put("--dirname","phonebook");

        //ЗАПИСАТЬ СРАЗУ В МЕТОД
        Class commandAdd  =  AddCommandImpl.class;
        Class commandFind = FindCommandImpl.class;
        Class commandList = ListCommandImpl.class;
        Class commandHelp = HelpCommandImpl.class;
        
        PhoneBookApplication phoneBookApplication = new PhoneBookApplicationBuilder()
                    .withCommands(new CommandDefinition("add", addParametrDefinitionsList, commandAdd))
                    .withCommands(new CommandDefinition("find", findParametrDefinitionsList, commandFind))
                    .withCommands(new CommandDefinition("list", listParametrDefinitionsList, commandList))
                    .withCommands(new CommandDefinition("help", helpParametrDefinitionsList, commandHelp))
                    .withConfig(matchOptionalParametrsWithDefaultValue)
                   .build();
        phoneBookApplication.run(args);
    }
}
