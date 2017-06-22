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

        Map<String,String>  mapToAdd = new HashMap<String, String>();
        mapToAdd.put("--filename","phonebook.txt");
        mapToAdd.put("--dirname","phonebook");

        Map<String,String>  mapToFind = new HashMap<String, String>();
        mapToFind.put("--filename","phonebook.txt");
        mapToFind.put("--dirname","phonebook");

        Map<String,String>  mapToList = new HashMap<String, String>();
        mapToList.put("--filename","phonebook.txt");
        mapToList.put("--dirname","phonebook");

        Class commandAdd  =  AddCommandImpl.class;
        Class commandFind = FindCommandImpl.class;
        Class commandList = ListCommandImpl.class;
        Class commandHelp = HelpCommandImpl.class;


         PhoneBookApplication phoneBookApplication = new PhoneBookApplicationBuilder()
                 .withCommands(new CommandDefinition("add", addParametrDefinitionsList,commandAdd))
                 .withConfig(mapToAdd)
                /* .withCommands(new CommandDefinition("find", findParametrDefinitionsList, commandFind))
                 .withConfig(mapToFind)
                 .withCommands(new CommandDefinition("list", listParametrDefinitionsList, commandList))
                 .withConfig(mapToList)
                 .withCommands(new CommandDefinition("help", helpParametrDefinitionsList, commandHelp))*/
                .build();

        phoneBookApplication.run(args);
    }
}
