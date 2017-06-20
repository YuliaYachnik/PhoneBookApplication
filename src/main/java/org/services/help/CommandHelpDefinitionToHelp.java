package org.services.help;

/**
 * Created by Юлия on 18.06.2017.
 */
public class CommandHelpDefinitionToHelp extends CommandDefinitionToHelp implements Help{
    private  String helpMessage = "\n\t\t\t HELP \t\t\t\n" +
            "This help-manager give you some description and syntax of the application command:\n" +
            "help";
    public void help(){
        super.hello();
        System.out.println(helpMessage);
    }

   public CommandDefinitionToHelp executeHelp() {
        help();
       return this;
   }
}
