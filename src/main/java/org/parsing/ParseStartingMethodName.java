package org.parsing;

import org.services.Command;
import org.services.add.AddCommandImpl;
import org.services.add.CommandAddDefinition;
import org.services.find.CommandFindDefinition;
import org.services.find.FindCommandImpl;
import org.services.help.CommandDefinitionToHelp;
import org.services.help.CommandHelpDefinitionToHelp;
import org.services.help.HelpCommandImpl;
import org.services.list.CommandListDefinition;
import org.services.list.ListCommandImpl;

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
                        CommandAddDefinition commandAddDefinition = new CommandAddDefinition();
                        ParseArguments parseArguments = new ParseArguments();
                        command = new AddCommandImpl(parseArguments.checkArgumentForAdd(args), commandAddDefinition);
                    } else if (arguments[0].equals("find")) {
                        CommandFindDefinition commandFindDefinition = new CommandFindDefinition();
                        ParseArguments parseArguments = new ParseArguments();
                        command = new FindCommandImpl(commandFindDefinition, parseArguments.checkArgumentForFind(args));
                    } else if (arguments[0].equals("list")) {
                        CommandListDefinition commandListDefinition = new CommandListDefinition();
                        ParseArguments parseArguments = new ParseArguments();
                        command = new ListCommandImpl(commandListDefinition, parseArguments.checkArgumentForList(args));
                    } else if (arguments[0].equals("help")) {
                        CommandDefinitionToHelp commandDefinitionToHelp = new CommandHelpDefinitionToHelp();
                        command = new HelpCommandImpl(commandDefinitionToHelp);
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
