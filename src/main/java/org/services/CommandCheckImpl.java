package org.services;

import org.check.Check;

import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 20.06.2017.
 */
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
    public boolean check(List<ParametrDefinitions> parametrDefinitions, Map<String, String> optionalParams, String args[]) {
        if (parametrDefinitions == null || args == null || optionalParams == null || args.length > 5) {
            throw new NullPointerException("Parametrs are not valid! Please, use help-manager");
        } else {
            if (checkMatchingOptionalAndArgsParametr() == true)
                return true;
            return false;
        }
    }

    public int getMandatoryArguments() {
        int mandatoryCount = 0;
        for (int i = 0; i < getParametrDefinitions().size(); i++) {
            if (getParametrDefinitions().get(i).isMandatory() == true) mandatoryCount++;
        }
        return mandatoryCount;
    }

    public boolean checkHelp() {
        if (getCommandArgumentsFromCommandLine().length == 1 && getCommandArgumentsFromCommandLine().length >= getParametrDefinitions().size())
            return true;
        else return false;
    }

    public boolean generalRuleCheck() {
        if (getCommandArgumentsFromCommandLine().length < getMandatoryArguments() + 1 || getCommandArgumentsFromCommandLine().length > getParametrDefinitions().size() + 1)
            return false;
        else return true;
    }

    public boolean checkMatchingOptionalAndArgsParametr() {

        if (generalRuleCheck() == true || checkHelp() == true) {
            if ((getCommandArgumentsFromCommandLine().length >= getMandatoryArguments() + 1) && getOptionalParams() == null)
                return false;
            return true;
        }
        return false;
    }
}
