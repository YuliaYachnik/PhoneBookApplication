package org.services;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommandCheckImplTest {
    List<ParametrDefinitions> parametrDefinitionsList;
    ParametrDefinitions name  = new ParametrDefinitions("name",true);
    ParametrDefinitions phone  = new ParametrDefinitions("phone",true);
    ParametrDefinitions filename  = new ParametrDefinitions("fileame",false);
    ParametrDefinitions dirname  = new ParametrDefinitions("dirname",false);

    CommandCheckImpl commandCheckForAdd = new CommandCheckImpl( initListOfAddDefinition(),initOptionalParamentrs(), initStringArgumentsForAdd());
    CommandCheckImpl commandCheckForHelp = new CommandCheckImpl(null,null,initStringArgumentsForHelp());
    CommandCheckImpl commandCheckForFind = new CommandCheckImpl(initListOfFindDefinition(),initOptionalParamentrs(),initStringArgumentsForFind());
    CommandCheckImpl commandCheckForList = new CommandCheckImpl(initListOfListDefinition(),initOptionalParamentrs(),initStringArgumentsForList());

    public String[] initStringArgumentsForAdd(){
        String[] returnString = new String[3];
        returnString[0] = "add";
       returnString[1] = "--name=Ivan";
       returnString[2] = "--phone=12345";
        return returnString;
    }
    public String[] initStringArgumentsForHelp(){
        String[] returnString = new String[1];
        returnString[0] = "help";
        return returnString;
    }

    public String[] initStringArgumentsForList(){
        String[] returnString = new String[1];
        returnString[0] = "list";
        return returnString;
    }

    public String[] initStringArgumentsForFind(){
        String[] returnString = new String[2];
        returnString[0] = "find";
        returnString[1] = "--name=Ivan";
        return returnString;
    }
    public List<ParametrDefinitions> initListOfAddDefinition(){
        parametrDefinitionsList = new ArrayList<>();
        parametrDefinitionsList.add(name);
        parametrDefinitionsList.add(phone);
        parametrDefinitionsList.add(filename);
        parametrDefinitionsList.add(dirname);
        return parametrDefinitionsList;
    }

    public List<ParametrDefinitions> initListOfFindDefinition(){
        parametrDefinitionsList = new ArrayList<>();
        parametrDefinitionsList.add(name);
        parametrDefinitionsList.add(filename);
        parametrDefinitionsList.add(dirname);
        return parametrDefinitionsList;
    }

    public List<ParametrDefinitions> initListOfListDefinition(){
        parametrDefinitionsList = new ArrayList<>();
        parametrDefinitionsList.add(filename);
        parametrDefinitionsList.add(dirname);
        return parametrDefinitionsList;
    }

    public Map<String,String> initOptionalParamentrs(){
        Map<String,String> optionalParametrs = new HashMap<>();
        optionalParametrs.put("--filename","phonebook.txt");
        optionalParametrs.put("--dirname","phonebook");
        return optionalParametrs;
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfOptionalAndArgsParametrNotMatchInAdd(){
        Assert.assertFalse(commandCheckForAdd.checkMatchingDefinitionAndArgsParametr());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfptionalAndArgsParametrNotMatchInFind(){
        Assert.assertFalse(commandCheckForFind.checkMatchingDefinitionAndArgsParametr());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfOptionalAndArgsParametrNotMatchInList(){
        Assert.assertFalse(commandCheckForList.checkMatchingDefinitionAndArgsParametr());
    }

    @Test(expected = NullPointerException.class)
    public  void throwExceptionIfOptionalAndArgsParametrNotMatchInHelp(){
        Assert.assertFalse(commandCheckForHelp.checkMatchingDefinitionAndArgsParametr());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfMandatryArgumentsIsNull(){
        Assert.assertNull(commandCheckForAdd.getMandatoryArguments());
    }

    @Test(expected = RuntimeException.class)
    public void throwExceptionIfNotCheckHelpArguments(){
        Assert.assertFalse(commandCheckForHelp.checkHelp());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfAddNotCheckGeneralRule(){
        Assert.assertFalse(commandCheckForAdd.generalRuleCheck());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfFindNotCheckGeneralRule(){
        Assert.assertFalse(commandCheckForFind.generalRuleCheck());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfListNotCheckGeneralRule(){
        Assert.assertFalse(commandCheckForList.generalRuleCheck());
    }

}