package org.services;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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

    @Test(expected = NullPointerException.class)
    public void throwExceptionIfArgsIsNull(){
     check.check(initListOfParametrDefinition(),initStringArgumentsOfParametrDefinition());
    }

    @Test(expected = NullPointerException.class)
    public void throwExceptionIfListIsNull(){
     check.check(initListOfParametrDefinition(),initStringArgumentsOfParametrDefinition());
    }

    @Test(expected = RuntimeException.class)
    public void throwExceptionIfNotReturnFalseBooleanValue(){
       assertFalse(check.check(initListOfParametrDefinition(),initStringArgumentsOfParametrDefinition()));
    }

     @Test(expected = RuntimeException.class)
     public void throwExceptionIfNotReturnTrueBooleanValue(){
    assertTrue(check.check(initListOfParametrDefinition(),initStringArgumentsOfParametrDefinition()));
  }
}