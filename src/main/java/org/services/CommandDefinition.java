package org.services;

import java.lang.*;
import java.util.List;

/**
 * Created by Юлия on 19.06.2017.
 */
public class CommandDefinition {
    private String name;
    private List<ParametrDefinitions> parametrDefinitions;
    private Class<Command> command;

    public String getName() {
        return name;
    }

    public List<ParametrDefinitions> getParametrDefinitions() {
        return parametrDefinitions;
    }

    public Class<Command> getCommand() {
        return command;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParametrDefinitions(List<ParametrDefinitions> parametrDefinitions) {
        this.parametrDefinitions = parametrDefinitions;
    }

    public CommandDefinition(String name, List<ParametrDefinitions> parametrDefinitions, Class<Command> command) {
        this.name = name;
        this.parametrDefinitions = parametrDefinitions;
        this.command = command;
    }

    public void setCommand(Class<Command> command) {
        this.command = command;
    }

}
