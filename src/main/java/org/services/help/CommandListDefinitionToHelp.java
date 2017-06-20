package org.services.help;

/**
 * Created by Юлия on 18.06.2017.
 */
public class CommandListDefinitionToHelp extends CommandDefinitionToHelp implements Help {
    private String listMessage = "\n\t\t\t LIST \t\t\t\n" +
            "With the help of this command, you can view information about all persons in default file:\n" +
            "list \n" +
            "With the help of this command, you can view information about all persons in your own file:\n" +
            "list [--filename=exampleFile.txt] [--dirname='exampledir]";
    public void listHelp(){
        super.hello();
        System.out.println(listMessage);
        super.notice();
    }

    public CommandDefinitionToHelp executeHelp() {
        listHelp();
        return this;
    }
}
