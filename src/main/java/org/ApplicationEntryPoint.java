package org;

import org.services.CommandDefinition;
import org.services.ParametrDefinitions;
import org.services.add.AddCommandImpl;
import org.services.find.FindCommandImpl;
import org.services.help.HelpCommandImpl;
import org.services.list.ListCommandImpl;

import java.util.*;

/**
 * Created by Юлия on 19.06.2017.
 */
public class ApplicationEntryPoint {
    public static void main(String args[]) throws ClassNotFoundException {

        List <ParametrDefinitions> addParametrDefinitionsList = new ArrayList <ParametrDefinitions> ();
        List <ParametrDefinitions> findParametrDefinitionsList = new ArrayList<>();
        List <ParametrDefinitions> listParametrDefinitionsList = new ArrayList<>();
        List <ParametrDefinitions> helpParametrDefinitionsList = new ArrayList<>();

        ParametrDefinitions nameParametrDefinitions = new ParametrDefinitions("name",true);
        ParametrDefinitions phoneParametrDefinitions = new ParametrDefinitions("phone",true);
        ParametrDefinitions fileParametrDefinitions = new ParametrDefinitions("filename", false);
        ParametrDefinitions dirParametrDefinitions = new ParametrDefinitions("dirname",false);

        addParametrDefinitionsList.add(nameParametrDefinitions);
        addParametrDefinitionsList.add(phoneParametrDefinitions);
        addParametrDefinitionsList.add(fileParametrDefinitions);
        addParametrDefinitionsList.add(dirParametrDefinitions);

        findParametrDefinitionsList.add(nameParametrDefinitions);
        findParametrDefinitionsList.add(fileParametrDefinitions);
        findParametrDefinitionsList.add(dirParametrDefinitions);

        listParametrDefinitionsList.add(fileParametrDefinitions);
        listParametrDefinitionsList.add(dirParametrDefinitions);

        Map<String,String>  matchOptionalParametrsWithDefaultValue = new HashMap<String, String>();
        matchOptionalParametrsWithDefaultValue.put("--filename","phonebook.txt");
        matchOptionalParametrsWithDefaultValue.put("--dirname","phonebook");


        Class commandAdd  =  AddCommandImpl.class;//перенести в метод
        Class commandFind = FindCommandImpl.class;//перенести в метод
        Class commandList = ListCommandImpl.class;//перенести в метод
        Class commandHelp = HelpCommandImpl.class;//перенести в метод


        PhoneBookApplication phoneBookApplication = new PhoneBookApplicationBuilder()
                    .withCommands(new CommandDefinition("add", addParametrDefinitionsList,commandAdd))
                    .withCommands(new CommandDefinition("find", findParametrDefinitionsList, commandFind))
                    .withCommands(new CommandDefinition("list", listParametrDefinitionsList, commandList))
                    .withCommands(new CommandDefinition("help", helpParametrDefinitionsList, commandHelp))
                    .withConfig(matchOptionalParametrsWithDefaultValue)
                   .build();
        phoneBookApplication.run(args);
    }
}
