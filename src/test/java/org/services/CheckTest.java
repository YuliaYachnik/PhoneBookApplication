package org.services;

import org.check.Check;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 22.06.2017.
 */
public class CheckTest {
   Check check = new CommandCheckImpl();

   public String[] initStringArgumentsOfParametrDefinition(){
     String[] returnString = new String[3];
     returnString[0] = "add";
     returnString[1] = "--name=Ivan";
     returnString[2] = "--phone=12345";
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

    @Test(expected = NullPointerException.class)
    public void throwExceptionIfStringArgsIsNull(){
     Assert.assertFalse(check.check(initListOfParametrDefinition(),initOptionalParamentrs(),initStringArgumentsOfParametrDefinition()));
    }

    @Test(expected = NullPointerException.class)
    public void throwExceptionIfListArgsIsNull(){
        Assert.assertFalse(check.check(null,initOptionalParamentrs(),initStringArgumentsOfParametrDefinition()));
    }

    @Test(expected = NullPointerException.class)
    public void throwExceptionOptionalParametrsIsNull(){
        Assert.assertFalse(check.check(initListOfParametrDefinition(),null,initStringArgumentsOfParametrDefinition()));
    }
    
}