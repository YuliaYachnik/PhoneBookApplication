package org.parsing;

import org.services.Command;
import org.services.add.AddCommandReceiver;
import org.services.find.FindCommandReceiver;
import org.services.help.CommandHelpDefinitionToHelp;
import org.services.list.ListCommandReceiver;

/**
 * Created by Юлия on 17.06.2017.
 */
public class ParseStartingMethodName {

    private final String[] methodName;

    private ParseStartingMethodName(ParseStartingMethodNameBuilder builder) {
        this.methodName = builder.methodName;
    }

    public Command startingParser(String[] args) throws ExceptionInInitializerError {
        String arguments[] = args;
        Command command = null;
        try {
            if (arguments.length == 0) {
                System.out.println("Error syntax. Please,use help-manager.");
                System.exit(0);
            } else {
                if (arguments.length > 5) {
                    System.out.println("So much arguments in function invoke. Please,use help-manager.");
                    System.exit(0);
                } else {
                    if (arguments[0].equals("add")) {
                        AddCommandReceiver addCommandReceiver = new AddCommandReceiver();
                        ParseArguments parseArguments = new ParseArguments();
                   //     command = new AddCommandImpl(parseArguments.checkArgumentForAdd(args), addCommandReceiver);
                    } else if (arguments[0].equals("find")) {
                        FindCommandReceiver findCommandReceiver = new FindCommandReceiver();
                        ParseArguments parseArguments = new ParseArguments();
                        //command = new FindCommandImpl(findCommandReceiver, parseArguments.checkArgumentForFind(args));
                    } else if (arguments[0].equals("list")) {
                        ListCommandReceiver listCommandReceiver = new ListCommandReceiver();
                        ParseArguments parseArguments = new ParseArguments();
                      //  command = new ListCommandImpl(listCommandReceiver, parseArguments.checkArgumentForList(args));
                    } else if (arguments[0].equals("help")) {
                      //  command = new HelpCommandImpl(commandDefinitionToHelp);
                    } else {
                        System.out.println("Error syntax. Please,use help-manager.");
                        System.exit(0);
                    }
                }
            }
        } catch (ExceptionInInitializerError exceptionInInitializerError) {
            System.out.println("Error of Initializing parameters.Please,use help-manager.");
        } catch (Exception e) {
            System.out.println("Error of Initializing parameters.Please,use help-manager.");
        }
        return command;
    }

    public ParseStartingMethodName run() {
        Command command = startingParser(methodName);
        command.execute();
        return this;
    }

    public static class ParseStartingMethodNameBuilder {
        private final String[] methodName;

        public ParseStartingMethodNameBuilder(String[] methodName) {
            this.methodName = methodName;
        }

        public ParseStartingMethodName build() {
            ParseStartingMethodName parseStartingMethodName = new ParseStartingMethodName(this);
            return parseStartingMethodName;
        }
    }
}
