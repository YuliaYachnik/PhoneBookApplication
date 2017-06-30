package org.services.help;

import org.date.DataObjectWorking;
import org.services.Command;

public class HelpCommandImpl implements Command {
    private  String messege = "\t\t\tWelcome to the Help-manager!\t\t\t" +
            "\n\t This application works with the phonebook.\t\n" +
            "You can ADD DATA to default file or to file that you created.\n" +
            "You can FIND DATE by person's name in your or in default file.\n" +
            "You can VIEW ALL DATE in in your file or in default file.\n" +
            "You can USE HELP-manager to help you work with application.\n\n" +
            "And now this is the syntax for invoking Command (You mast carefully assign Command in command line.)";

    private String noticeFileAndDir = "\nNOTICE: If you specify your own file, then you also need to specify the directory!";

    private String addMessage = "\n\t\t\t ADD \t\t\t\n" +
            "With the help of this command, you can write to default file" +
            " data about the person (his name and his contact phone number):\n" +
            "add --param1=Param1 --param2=Param2\n" +
            "With the help of this command, you can write to your own file" +
            "add --param1=Param1 --param2=Param2 [--filename=exampleFile.txt] [--dirname='exampledir]";

    private  String findMessage = "\n\t\t\t FIND \t\t\t\n" +
            "With the help of this command, you can find some information by Param1" +
            "in default file:\n" +
            "find --param1=Param1\n" +
            "in your own file:\n" +
            "find --param1=Param1[--filename=exampleFile.txt] [--dirname='exampledir]";

    private String listMessage = "\n\t\t\t LIST \t\t\t\n" +
            "With the help of this command, you can view all information in default file:\n" +
            "list \n" +
            "in your own file:\n" +
            "list [--filename=exampleFile.txt] [--dirname='exampledir]";

    private  String helpMessage = "\n\t\t\t HELP \t\t\t\n" +
            "This help-manager give you some description and syntax of the application command:\n" +
            "help";

    public void execute(DataObjectWorking objectClass) {
        System.out.println(messege);
        System.out.println(helpMessage);
        System.out.println(addMessage);
        System.out.println(noticeFileAndDir);
        System.out.println(findMessage);
        System.out.println(noticeFileAndDir);
        System.out.println(listMessage);
        System.out.println(noticeFileAndDir);
    }
}
