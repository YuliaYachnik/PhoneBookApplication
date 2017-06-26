package org.services;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Юлия on 26.06.2017.
 */
public class CommandCheckImplTest {
    CommandCheckImpl commandCheck = new CommandCheckImpl(initListOfParametrDefinition(),initOptionalParamentrs(),initStringArgumentsOfParametrDefinition());
    CommandCheckImpl commandCheckForHelp = new CommandCheckImpl(null,null,initStringArgumentsForHelp());

    public String[] initStringArgumentsOfParametrDefinition(){
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
    public List<ParametrDefinitions> initListOfParametrDefinition(){
        List<ParametrDefinitions> parametrDefinitionsList = new ArrayList<>();
        ParametrDefinitions name  = new ParametrDefinitions("name",true);
        ParametrDefinitions phone  = new ParametrDefinitions("phone",true);
        ParametrDefinitions filename  = new ParametrDefinitions("fileame",false);
        ParametrDefinitions dirname  = new ParametrDefinitions("dirname",false);
        parametrDefinitionsList.add(name);
        parametrDefinitionsList.add(phone);
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
        Assert.assertFalse(commandCheck.checkMatchingOptionalAndArgsParametrInAdd());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfptionalAndArgsParametrNotMatchInFind(){
        Assert.assertFalse(commandCheck.checkMatchingOptionalAndArgsParametrInFind());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfOptionalAndArgsParametrNotMatchInList(){
        Assert.assertFalse(commandCheck.checkMatchingOptionalAndArgsParametrInList());
    }

    @Test(expected = AssertionError.class)
    public  void throwExceptionIfOptionalAndArgsParametrNotMatchInHelp(){
        Assert.assertFalse(commandCheckForHelp.checkMatchingOptionalAndArgsParametrInHelp());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfMandatryArgumentsIsNull(){
        Assert.assertNull(commandCheck.getMandatryArguments());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfNameOfMethodIsNull(){
        Assert.assertNotEquals(initStringArgumentsOfParametrDefinition()[0],commandCheck.getNameOfMethod());
    }



}