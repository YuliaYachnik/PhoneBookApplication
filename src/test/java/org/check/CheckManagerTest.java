package org.check;

import org.junit.Assert;
import org.junit.Test;
import org.services.CommandCheckImpl;
import org.services.ParametrDefinitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class CheckManagerTest {
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
    CheckManager addCheckManager = new CheckManager(commandCheckForAdd);
    CheckManager findCheckManager = new CheckManager(commandCheckForFind);
    CheckManager listCheckManager = new CheckManager(commandCheckForList);
    CheckManager helpCheckManager = new CheckManager(commandCheckForHelp);
    CheckManager nullManager = new CheckManager(null);

    @Test(expected = AssertionError.class)
    public void throwExceptionIfDoNotReturnAddValidateObject() throws Exception {
      Assert.assertNull(addCheckManager.returnValidateObject());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfDoNotReturnFindValidateObject() throws Exception {
        Assert.assertNull(findCheckManager.returnValidateObject());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfDoNotReturnListValidateObject() throws Exception {
        Assert.assertNull(listCheckManager.returnValidateObject());
    }

    @Test(expected = NullPointerException.class)
    public void throwExceptionIfDoNotReturnHelpValidateObject() throws Exception {
        Assert.assertNull(helpCheckManager.returnValidateObject());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfDoNotAddArgumentIntoAdd() throws Exception {
        Assert.assertNull(addCheckManager.addArgumentsIntoAdd());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfDoNotAddArgumentIntoFind() throws Exception {
        Assert.assertNull(findCheckManager.addArgumentsIntoFind());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfDoNotAddArgumentIntoList() throws Exception {
        Assert.assertNull(listCheckManager.addArgumentsIntoList());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfDoNotAddArgumentIntoHelp() throws Exception {
        Assert.assertNull(helpCheckManager.addArgumentsIntoHelp());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfDoNotAddOptionalIsNull() throws Exception {
        Assert.assertTrue(addCheckManager.isOptionalNull());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfDoNotFindOptionalIsNull() throws Exception {
        Assert.assertTrue(findCheckManager.isOptionalNull());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfDoNotListOptionalIsNull() throws Exception {
        Assert.assertTrue(listCheckManager.isOptionalNull());
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfHelpOptionalIsNull() throws Exception {
        Assert.assertFalse(helpCheckManager.isOptionalNull());
    }

    @Test(expected = Exception.class)
    public void throwExceptionIfDoNotGetName() throws Exception {
        Assert.assertNull(addCheckManager.getName(commandCheckForAdd.getCommandArgumentsFromCommandLine()[0]));
    }


    @Test(expected = Exception.class)
    public void throwExceptionIfDoNotGetPhone() throws Exception {
        Assert.assertNull(addCheckManager.getPhone(commandCheckForAdd.getCommandArgumentsFromCommandLine()[1]));
    }


    @Test(expected = Exception.class)
    public void throwExceptionIfDoNotGetFileName() throws Exception {
        Assert.assertNull(addCheckManager.getFileName(commandCheckForAdd.getCommandArgumentsFromCommandLine()[2]));
    }


    @Test(expected = Exception.class)
    public void throwExceptionIfDoNotGetDirName() throws Exception {
        Assert.assertNull(addCheckManager.getFileDir(commandCheckForAdd.getCommandArgumentsFromCommandLine()[3]));
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfDoNotCheckNameSymbol(){
        Assert.assertNull(CheckManager.checkNameSymbol(commandCheckForAdd.getCommandArgumentsFromCommandLine()[0]));
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfDoNotCheckPhoneSymbol(){
        Assert.assertNull(CheckManager.checkPhoneSymbol(commandCheckForAdd.getCommandArgumentsFromCommandLine()[1]));
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfDoNotCheckFileNameSymbol(){
        Assert.assertNull(CheckManager.checkFileName(commandCheckForAdd.getOptionalParams().get("--filename")));
    }

    @Test(expected = AssertionError.class)
    public void throwExceptionIfDoNotCheckDirNameSymbol(){
        Assert.assertNull(CheckManager.checkFileDir(commandCheckForAdd.getOptionalParams().get("--dirname")));
    }
}