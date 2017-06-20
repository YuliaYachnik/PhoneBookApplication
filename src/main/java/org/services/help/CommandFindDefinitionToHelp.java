package org.services.help;

/**
 * Created by Юлия on 18.06.2017.
 */
public class CommandFindDefinitionToHelp extends CommandDefinitionToHelp implements Help{
    private  String findMessage = "\n\t\t\t FIND \t\t\t\n" +
            "With the help of this command, you can find phone number of any person by his name" +
            "in default file:\n" +
            "find --name='Name'\n" +
            "With the help of this command, you can find phone number of any person by his name" +
            "in your own file:\n" +
            "find --name='Name'  [--filename=exampleFile.txt] [--dirname='exampledir]";
    public void findHelp(){
        super.hello();
        System.out.println(findMessage);
        super.notice();
    }

    public CommandDefinitionToHelp executeHelp() {
        findHelp();
        return this;
    }
}
