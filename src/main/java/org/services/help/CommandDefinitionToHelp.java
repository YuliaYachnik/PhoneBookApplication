package org.services.help;

import org.parsing.ParseArguments;

/**
 * Created by Юлия on 16.06.2017.
 */
public abstract  class CommandDefinitionToHelp{
    private  String messege = "\t\t\tWelcome to the Help-manager!\t\t\t" +
            "\n\t This application works with the phonebook.\t\n" +
            "You can ADD DATA to default file or to file that you created.\n" +
            "You can FIND DATE by person's name in your or in default file.\n" +
            "You can VIEW ALL DATE in in your file or in default file.\n" +
            "You can USE HELP-manager to help you work with application.\n\n" +
            "And now this is the syntax for invoking Command (You mast carefully assign Command in cimmand line/)";

    private String noticeFileAndDir = "\nNOTICE: If you specify your own file, then you also need to specify the directory!";

    public  void hello() {
        System.out.println(messege);
    }
   public  void notice(){
        System.out.println(noticeFileAndDir);
    }

}
