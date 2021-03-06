package org.services;

import java.lang.*;
import java.util.List;

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

    public CommandDefinition(String name, List<ParametrDefinitions> parametrDefinitions, Class<Command> command) {
        this.name = name;
        this.parametrDefinitions = parametrDefinitions;
        this.command = command;
    }
}
