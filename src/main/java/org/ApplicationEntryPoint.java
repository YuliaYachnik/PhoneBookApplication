package org;

import org.services.CommandDefinition;
import org.services.ParametrDefinitions;
import org.services.add.AddCommandImpl;
import org.services.find.FindCommandImpl;
import org.services.help.HelpCommandImpl;
import org.services.list.ListCommandImpl;

import java.lang.reflect.Array;
import java.util.*;

public class ApplicationEntryPoint {
    public static void main(String args[]) throws ClassNotFoundException {

        Class command;

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

        PhoneBookApplication phoneBookApplication = new PhoneBookApplicationBuilder()
                    .withCommands(new CommandDefinition("add", addParametrDefinitionsList,command = new AddCommandImpl().getClass()))
                    .withCommands(new CommandDefinition("find", findParametrDefinitionsList, command = new FindCommandImpl().getClass()))
                    .withCommands(new CommandDefinition("list", listParametrDefinitionsList,command = new ListCommandImpl().getClass()))
                    .withCommands(new CommandDefinition("help", helpParametrDefinitionsList, command = new HelpCommandImpl().getClass()))
                    .withConfig(matchOptionalParametrsWithDefaultValue)
                   .build();
        phoneBookApplication.run(args);
    }
}
