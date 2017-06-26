package org.check;

import org.date.Data;
import org.services.CommandCheckImpl;
import org.services.ParametrDefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Юлия on 26.06.2017.
 */
public class CheckManager {
    private CommandCheckImpl commandCheck;
    private Map<String,Data> matchMethodNameWithParser;
    private Data data;
  /*  private  String stringArgsCheck[];
    private List<ParametrDefinitions> parametrDefinitionsList;
    private Map<String,String> optionalParams;*/

    public CheckManager(CommandCheckImpl commandCheck) {
        this.commandCheck = commandCheck;
        matchMethodNameWithParser = new HashMap<>();
        try {
            matchMethodNameWithParser.put("add", addArgumentsIntoAdd());
            matchMethodNameWithParser.put("help",addArgumentsIntoHelp());
            matchMethodNameWithParser.put("list",addArgumentsIntoList());
            matchMethodNameWithParser.put("find",addArgumentsIntoFind());
        } catch (Exception e) {
            System.out.println("Error with command line parametrs. Please, use help-manager.");
        }

    }

    public Map<String, Data> getMatchMethodNameWithParser() {
        return matchMethodNameWithParser;
    }

    public Data returnValidateObject()throws InstantiationException, IllegalAccessException{
        if(commandCheck.check(commandCheck.getParametrDefinitions(),commandCheck.getOptionalParams(),commandCheck.getCommandArgumentsFromCommandLine()) == true){
            return getMatchMethodNameWithParser().get(commandCheck.getCommandArgumentsFromCommandLine()[0]);
        }else {
            throw new RuntimeException("Error with command line parametrs. Please, use help-manager.");
        }
    }

    private Data addArgumentsIntoHelp(){
        Data data = new Data();
        return data;
    }

    public boolean isOptionalNull(){
        if(commandCheck.getOptionalParams() == null) return true;
        else  return false;
    }

    private Data addArgumentsIntoAdd() throws Exception{
       data = new Data();
       data.setName(getName(commandCheck.getCommandArgumentsFromCommandLine()[1]));
        data.setPhone(getPhone(commandCheck.getCommandArgumentsFromCommandLine()[2]));
        if(isOptionalNull()) {
           data.setFileName(getFileName(commandCheck.getCommandArgumentsFromCommandLine()[3]));
            data.setDirName(getFileDir(commandCheck.getCommandArgumentsFromCommandLine()[4]));
        }else{
            if(countArguments(commandCheck.getCommandArgumentsFromCommandLine()) == 3){
                data.setFileName(commandCheck.getOptionalParams().get("--filename"));
                data.setDirName (commandCheck.getOptionalParams().get("--dirname"));
            }
            if(countArguments(commandCheck.getCommandArgumentsFromCommandLine()) == 4){
                if(getFileName(commandCheck.getCommandArgumentsFromCommandLine()[4]) == null)
                {
                    data.setFileName(commandCheck.getOptionalParams().get("--filename"));
                    data.setDirName (commandCheck.getCommandArgumentsFromCommandLine()[3]);
                }else{
                    data.setFileName (commandCheck.getCommandArgumentsFromCommandLine()[3]);
                    data.setDirName(commandCheck.getOptionalParams().get("--dirname"));
                }
            }
            if(countArguments(commandCheck.getCommandArgumentsFromCommandLine()) == 5){
                data.setFileName(getFileName(commandCheck.getCommandArgumentsFromCommandLine()[3]));
                data.setDirName(getFileDir(commandCheck.getCommandArgumentsFromCommandLine()[4]));
            }
        }
        return data;
    }

   private Data addArgumentsIntoList( ){
        Data data = null;
        if(isOptionalNull() == true){
            try {
                String filename = getFileName(stringArgsCheck[1]);
                String dirname = getFileDir(stringArgsCheck[2]);
                data = new Data();
                data.setFileName(filename);
                data.setDirName(dirname);
                return data;
            } catch (Exception e) {
                System.out.println("Incorrect data initializing. Please,use help-manager.");
            }
        }else{
            return chooseVersionOfListing();
        }
        return data;
    }

   private Data chooseVersionOfListing(){
        Data data = null;
        try {
            if(countArguments(getStringArgsCheck()) == 1){
                String filename = getOptionalParams().get("--filename");
                String dirname = getOptionalParams().get("--dirname");
                data = new Data();
                data.setFileName(filename);
                data.setDirName(dirname);
            }
            if(countArguments(getStringArgsCheck()) == 2){
                String filename = getFileName(getStringArgsCheck()[1]);
                String dirname = getOptionalParams().get("--dirname");
                data = new Data();
                data.setFileName(filename);
                data.setDirName(dirname);
            }
            if(countArguments(getStringArgsCheck()) == 3){
                String filename = getFileName(getStringArgsCheck()[1]);
                String dirname = getFileDir(getStringArgsCheck()[2]);
                data = new Data();
                data.setFileName(filename);
                data.setDirName(dirname);
            }
        } catch (Exception e) {
            System.out.println("Incorrect data initializing. Please,use help-manager.");
        }
        return data;
    }

    private Data addArgumentsIntoFind( ){
        Data data = null;
        if(isOptionalNull() == true){
            try {
                String name = getName(stringArgsCheck[1]);
                String filename = getFileName(stringArgsCheck[3]);
                String dirname = getFileDir(stringArgsCheck[4]);
                data = new Data();
                data.setName(name);
                data.setFileName(filename);
                data.setDirName(dirname);
                return data;

            } catch (Exception e) {
                System.out.println("Incorrect data initializing. Please,use help-manager.");
            }
        }else{
            return chooseVersionOfFinding();
        }
        return data;
    }

    private Data chooseVersionOfFinding(){
        Data data = null;
        try {
            if(countArguments(getStringArgsCheck()) == 2) {
                String name = getName(getStringArgsCheck()[1]);
                String filename = getOptionalParams().get("--filename");
                String dirname = getOptionalParams().get("--dirname");
                data = new Data();
                data.setName(name);
                data.setFileName(filename);
                data.setDirName(dirname);
            }
            if(countArguments(getStringArgsCheck()) == 3){
                String name = getName(getStringArgsCheck()[1]);
                String filename = getFileName(getStringArgsCheck()[2]);
                String dirname = getOptionalParams().get("--dirname");
                data = new Data();
                data.setName(name);
                data.setFileName(filename);
                data.setDirName(dirname);
            }
            if(countArguments(getStringArgsCheck()) == 4){
                String name = getName(getStringArgsCheck()[1]);
                String filename = getFileName(getStringArgsCheck()[2]);
                String dirname = getFileDir(getStringArgsCheck()[3]);
                data = new Data();
                data.setName(name);
                data.setFileName(filename);
                data.setDirName(dirname);
            }
        } catch (Exception e) {
            System.out.println("Incorrect data initializing. Please,use help-manager.");
        }
        return data;
    }




    private int countArguments(String arguments[]){
        return arguments.length;
    }

    public static boolean checkNameSymbol(String str) {
        Pattern p = Pattern.compile("^--name=+[a-zA-ZА-Яа-я]{3,15}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public String getName(String str) throws Exception {
        String returnName = "";
        if (checkNameSymbol(str) == true) {
            for (String value : str.split("=")) {
                returnName = value;
            }
            return returnName;
        } else {
            throw new Exception("Incorrect name data.Please,use help-manager.");
        }
    }

    public static boolean checkPhoneSymbol(String str) {
        Pattern p = Pattern.compile("^--phone=+[0-9]{3,20}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public String getPhone(String str) throws Exception {
        if (checkPhoneSymbol(str) == true) {
            String returnPhone = "";
            for (String value : str.split("=")) {
                returnPhone = value;
            }
            return returnPhone;
        } else {
            throw new Exception("Incorrect phone number. Please,use help-manager.");
        }
    }

    public static boolean checkFileName(String str) {
        Pattern p = Pattern.compile("\\[--filename=.+\\.txt\\]");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public String getFileName(String str) throws Exception {
        if (checkFileName(str) == true) {
            String returnFileName = "";
            for (String value : str.split("=")) {
                returnFileName = value;
            }
            return returnFileName.substring(0, returnFileName.length() - 1);
        } else {
            throw new Exception("Incorrect file name. Please,use help-manager.");
        }
    }

    public static boolean checkFileDir(String str) {
        Pattern p = Pattern.compile("\\[--dirname=+[a-zA-ZА-Яа-я0-9]{3,15}\\]");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public String getFileDir(String str) throws Exception {

        if (checkFileDir(str) == true) {
            String returnFileDir = "";
            for (String value : str.split("=")) {
                returnFileDir = value;
            }
            return returnFileDir.substring(0, returnFileDir.length() - 1);
        } else {
            throw new Exception("Incorrect name of directory. Please,use help-manager.");
        }
    }
}

