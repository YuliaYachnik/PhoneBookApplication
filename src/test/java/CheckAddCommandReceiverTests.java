import org.PhoneBookApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.services.ParametrDefinitions;
import org.services.add.checkAdd.CheckAddCommandReceiver;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Юлия on 21.06.2017.
 */
public class CheckAddCommandReceiverTests {
    private CheckAddCommandReceiver checkAddCommandReceiver;
    private List<ParametrDefinitions> parametrDefinitionsList;
    private ParametrDefinitions parametrDefinitions;


    public ParametrDefinitions  setParametrDefinitions(String str, boolean flag){
        parametrDefinitions = new ParametrDefinitions(str,flag);
        return parametrDefinitions;
    }

    public List<ParametrDefinitions> setParametrDefinitionsList(){
        parametrDefinitionsList = new ArrayList<>(4);
        parametrDefinitionsList.add(0,setParametrDefinitions("name",true));
        parametrDefinitionsList.add(1,setParametrDefinitions("phone",true));
        parametrDefinitionsList.add(2,setParametrDefinitions("filename",false));
        parametrDefinitionsList.add(3,setParametrDefinitions("dirname",true));
        return parametrDefinitionsList;

    }

    @Before
    public void init(){
        checkAddCommandReceiver  = new CheckAddCommandReceiver();
        checkAddCommandReceiver.setParametrDefinitions(setParametrDefinitionsList());
    }

    @Test
    public void checkName(){
       assertEquals(true,CheckAddCommandReceiver.checkNameSymbol("--name=Ivan"));
    }

    @Test
    public void checkGetNameFromCommandLine() {
        try {
            assertEquals("Ivan",checkAddCommandReceiver.getName("--name=Ivan"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkPhone(){
        assertEquals(true,CheckAddCommandReceiver.checkPhoneSymbol("--phone=12345"));
    }

    @Test
    public void checkGetPhoneFromCommandLine(){
        try {
            assertEquals("12345",checkAddCommandReceiver.getPhone("--phone=12345"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkFileName(){
        assertEquals(true,CheckAddCommandReceiver.checkFileName("[--filename=file.txt]"));
    }

    @Test
    public void checkGetFileNameFromCommandLine(){
        try {
            assertEquals("file.txt",checkAddCommandReceiver.getFileName("[--filename=file.txt]"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkDirName(){
        assertEquals(true,CheckAddCommandReceiver.checkFileDir("[--dirname=mydir]"));
    }

    @Test
    public void checkDirNameFromCommandLine(){
        try {
            assertEquals("mydir",checkAddCommandReceiver.getFileDir("[--dirname=mydir]"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {

        JUnitCore runner = new JUnitCore();
        Result result = runner.run(CheckAddCommandReceiverTests.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }
}
