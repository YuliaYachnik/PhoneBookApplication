package org.services;

import org.check.Check;
import java.util.List;
import java.util.Map;

public class CommandCheckImpl implements Check {
    private List<ParametrDefinitions> parametrDefinitions;
    private Map<String, String> optionalParams;
    private String[] commandArgumentsFromCommandLine;

    public CommandCheckImpl() {
    }

    public CommandCheckImpl(List<ParametrDefinitions> parametrDefinitions, Map<String, String> optionalParams, String[] commandArgumentsFromCommandLine) {
        this.parametrDefinitions = parametrDefinitions;
        this.optionalParams = optionalParams;
        this.commandArgumentsFromCommandLine = commandArgumentsFromCommandLine;
    }

    public List<ParametrDefinitions> getParametrDefinitions() {
        return parametrDefinitions;
    }

    public String[] getCommandArgumentsFromCommandLine() {
        return commandArgumentsFromCommandLine;
    }

    public Map<String, String> getOptionalParams() {
        return optionalParams;
    }

    @Override
    public boolean check(List<ParametrDefinitions> parametrDefinitions, Map<String, String> optionalParams, String args[]) throws NullPointerException{
        if (parametrDefinitions == null || args == null || args.length > 5) {
            throw new NullPointerException("Parametrs are not valid! Please, use help-manager");
        } else {
            return checkMatchingDefinitionAndArgsParametr();
        }
    }

    public int getMandatoryArguments() {
        int mandatoryCount = 0;
        for (int i = 0; i < getParametrDefinitions().size(); i++) {
            if (getParametrDefinitions().get(i).isMandatory()) mandatoryCount++;
        }
        return mandatoryCount;
    }

    public boolean checkHelp() {
        return getCommandArgumentsFromCommandLine().length == 1 && getCommandArgumentsFromCommandLine().length >= getParametrDefinitions().size();
    }

    public boolean generalRuleCheck() {
        return !(getCommandArgumentsFromCommandLine().length < getMandatoryArguments() + 1 || getCommandArgumentsFromCommandLine().length > getParametrDefinitions().size() + 1);
    }

    public boolean checkMatchingDefinitionAndArgsParametr() {
        return generalRuleCheck() || checkHelp();
    }
}
