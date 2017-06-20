package org.services.help;

/**
 * Created by Юлия on 18.06.2017.
 */
public class CommandAddDefinitionToHelp extends CommandDefinitionToHelp implements Help {
    private String addMessage = "\n\t\t\t ADD \t\t\t\n" +
            "With the help of this command, you can write to default file" +
            " data about the person (his name and his contact phone number):\n" +
            "add --name='Name' --phone='12345'\n" +
            "With the help of this command, you can write to your own file" +
            " data about the person (his name and his contact phone number):\n" +
            "add --name='Name' --phone='12345' [--filename=exampleFile.txt] [--dirname='exampledir]";
    public void addHelp(){
        super.hello();
        System.out.println(addMessage);
        super.notice();
    }

    public CommandDefinitionToHelp executeHelp() {
        addHelp();
        return this;
    }
}
