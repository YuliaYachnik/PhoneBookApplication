package org;

import org.date.DataObjectWorking;
import org.services.CommandDefinition;
import org.services.ParametrDefinitions;
import org.services.add.AddCommandImpl;
import org.services.find.FindCommandImpl;
import org.services.help.HelpCommandImpl;
import org.services.list.ListCommandImpl;

import java.util.*;

public class ApplicationEntryPoint {
    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class command;
        Class objectClassPhoneBook = Class.forName("org.date.PhoneBookData");
        DataObjectWorking bookObject  = (DataObjectWorking)objectClassPhoneBook.newInstance();

        Class objectClassLibrary = Class.forName("org.date.LibraryData");
        DataObjectWorking printLibraryObject = (DataObjectWorking)objectClassLibrary.newInstance();

        Class objectClassHotel = Class.forName("org.date.HotelBookData");
        DataObjectWorking printHotelObject = (DataObjectWorking)objectClassLibrary.newInstance();

        ParametrDefinitions nameParametrDefinitions = new ParametrDefinitions("param1",true);
        ParametrDefinitions phoneParametrDefinitions = new ParametrDefinitions("param2",true);
        ParametrDefinitions fileParametrDefinitions = new ParametrDefinitions("filename", false);
        ParametrDefinitions dirParametrDefinitions = new ParametrDefinitions("dirname",false);

        List <ParametrDefinitions> addParametrDefinitionsList = Arrays.asList(nameParametrDefinitions,phoneParametrDefinitions,fileParametrDefinitions,dirParametrDefinitions);
        List <ParametrDefinitions> findParametrDefinitionsList = Arrays.asList(nameParametrDefinitions,fileParametrDefinitions,dirParametrDefinitions);
        List <ParametrDefinitions> listParametrDefinitionsList = Arrays.asList(fileParametrDefinitions,dirParametrDefinitions);
        List <ParametrDefinitions> helpParametrDefinitionsList = new ArrayList<>();

        Map<String,String>  matchOptionalParametrsWithDefaultValue = new HashMap<>();
        matchOptionalParametrsWithDefaultValue.put("--filename","defaultFile.txt");
        matchOptionalParametrsWithDefaultValue.put("--dirname","defaultdDir");



        PhoneBookApplication phoneBookApplication = new PhoneBookApplicationBuilder()
                    .forData(bookObject)
                   //.forData(printLibraryObject)
                    //.forData(setGetObject = new LibraryData().getClass())
                    //.forData(setGetObject = new HotelBookData().getClass())
                    .withCommands(new CommandDefinition("add", addParametrDefinitionsList,command = new AddCommandImpl().getClass()))
                    .withCommands(new CommandDefinition("find", findParametrDefinitionsList, command = new FindCommandImpl().getClass()))
                    .withCommands(new CommandDefinition("list", listParametrDefinitionsList,command = new ListCommandImpl().getClass()))
                    .withCommands(new CommandDefinition("help", helpParametrDefinitionsList, command = new HelpCommandImpl().getClass()))
                    .withConfig(matchOptionalParametrsWithDefaultValue)
                   .build();
        phoneBookApplication.run(args);
    }
}
