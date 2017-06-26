package org.services;

import org.date.Data;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Юлия on 23.06.2017.
 */
public class CheckManager {
    private Data data;
    private  String stringArgsCheck[];
    private List<ParametrDefinitions> parametrDefinitionsList;
    private  Map<String,String> optionalParams;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setStringArgsCheck(String[] stringArgsCheck) {
        this.stringArgsCheck = stringArgsCheck;
    }

    public void setParametrDefinitionsList(List<ParametrDefinitions> parametrDefinitionsList) {
        this.parametrDefinitionsList = parametrDefinitionsList;
    }

    public void setOptionalParams(Map<String, String> optionalParams) {
        this.optionalParams = optionalParams;
    }

    public String[] getStringArgsCheck() {
        return stringArgsCheck;
    }

    public Map<String, String> getOptionalParams() {
        return optionalParams;
    }

    public Data returnValideObject(CommandCheckImpl commandCheck){
        String stringArgsCheck[] = commandCheck.getCommandArgumentsFromCommandLine();
        setStringArgsCheck(stringArgsCheck);
        Map<String,String> optionalParams = commandCheck.getOptionalParams();
        setOptionalParams(optionalParams);
        List<ParametrDefinitions> parametrDefinitionsList = commandCheck.getParametrDefinitions();
        setParametrDefinitionsList(parametrDefinitionsList);

        if(commandCheck.check(parametrDefinitionsList,optionalParams,stringArgsCheck) == true){
            return chooseVersionOfParsing(stringArgsCheck[0]);
        }else {
            throw new RuntimeException("Error with command line parametrs. Please, use help-manager.");
        }
    }

    private Data chooseVersionOfParsing(String nameOfMethod){
        if(nameOfMethod.equals("add"))  return addArgumentsIntoAdd(getStringArgsCheck());
        if(nameOfMethod.equals("find")) return addArgumentsIntoFind(getStringArgsCheck());
        if(nameOfMethod.equals("list")) return addArgumentsIntoList(getStringArgsCheck());
      else return addArgumentsIntoHelp();
    }
    private Data addArgumentsIntoHelp(){
        Data data = new Data();
        return data;
    }

    private Data addArgumentsIntoList(String stringArgsCheck[] ){
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

    private Data addArgumentsIntoFind(String stringArgsCheck[] ){
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

    private Data addArgumentsIntoAdd(String stringArgsCheck[] ){
        Data data = null;
        if(isOptionalNull() == true){
            try {
                String name = getName(stringArgsCheck[1]);
                String phone = getPhone(stringArgsCheck[2]);
                String filename = getFileName(stringArgsCheck[3]);
                String dirname = getFileDir(stringArgsCheck[4]);
                data = new Data(name,phone,filename,dirname);
                return data;

            } catch (Exception e) {
                System.out.println("Incorrect data initializing. Please,use help-manager.");
            }
        }else{
           return chooseVersionOfAdding();
        }
        return data;
    }

    private Data chooseVersionOfAdding(){
        Data data = null;
        try {
                if(countArguments(getStringArgsCheck()) == 3) {
                    String name = getName(getStringArgsCheck()[1]);
                    String phone = getPhone(getStringArgsCheck()[2]);
                    String filename = getOptionalParams().get("--filename");
                    String dirname = getOptionalParams().get("--dirname");
                    data = new Data(name,phone,filename,dirname);
                }
                if(countArguments(getStringArgsCheck()) == 4){
                    String name = getName(getStringArgsCheck()[1]);
                    String phone = getPhone(getStringArgsCheck()[2]);
                    String filename = getFileName(getStringArgsCheck()[3]);
                    String dirname = getOptionalParams().get("--dirname");
                    data = new Data(name,phone,filename,dirname);
                }
                if(countArguments(getStringArgsCheck()) == 5){
                    String name = getName(getStringArgsCheck()[1]);
                    String phone = getPhone(getStringArgsCheck()[2]);
                    String filename = getFileName(getStringArgsCheck()[3]);
                    String dirname = getFileDir(getStringArgsCheck()[4]);
                    data = new Data(name,phone,filename,dirname);
                }
            } catch (Exception e) {
               System.out.println("Incorrect data initializing. Please,use help-manager.");
            }
        return data;
    }


    private int countArguments(String arguments[]){
        return arguments.length;
    }

    public boolean isOptionalNull(){
       if(getOptionalParams() == null) return true;
        else  return false;
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
