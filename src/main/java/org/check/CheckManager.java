package org.check;

import org.date.Data;
import org.services.CommandCheckImpl;
import org.services.ParametrDefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

/**
 * Created by Юлия on 26.06.2017.
 */
public class CheckManager {
    private CommandCheckImpl commandCheck;
    private Data data;

    public CheckManager(CommandCheckImpl commandCheck) {
        this.commandCheck = commandCheck;
    }

    public Data returnValidateObject() throws Exception {
        if(commandCheck.check(commandCheck.getParametrDefinitions(),commandCheck.getOptionalParams(),commandCheck.getCommandArgumentsFromCommandLine())){
            chooseMethodName(commandCheck.getCommandArgumentsFromCommandLine()[0]);
            return data;
        }else {
            throw new DataFormatException();
        }
    }

    public void chooseMethodName(String name) throws Exception {
        if(name.equals("add")) addArgumentsIntoAdd();
        if(name.equals("find")) addArgumentsIntoFind();
        if(name.equals("list")) addArgumentsIntoList();
        if(name.equals("help")) addArgumentsIntoHelp();
    }

    public  Data addArgumentsIntoHelp(){
        Data data = new Data();
        return data;
    }

    public boolean isOptionalNull(){
        if(commandCheck.getOptionalParams() == null) return true;
        else  return false;
    }

    public Data addArgumentsIntoAdd() throws Exception{
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
                if(commandCheck.getCommandArgumentsFromCommandLine()[3].contains("--dirname"))
                {
                    data.setFileName(commandCheck.getOptionalParams().get("--filename"));
                    data.setDirName (getFileDir(commandCheck.getCommandArgumentsFromCommandLine()[3]));
                }else{
                    data.setFileName (getFileName(commandCheck.getCommandArgumentsFromCommandLine()[3]));
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

   public Data addArgumentsIntoList( ) throws Exception{
        data = new Data();
        if(isOptionalNull()){
                data.setFileName(getFileName(commandCheck.getCommandArgumentsFromCommandLine()[1]));
                data.setDirName(getFileDir(commandCheck.getCommandArgumentsFromCommandLine()[2]));
           }else{
            if(countArguments(commandCheck.getCommandArgumentsFromCommandLine()) == 2){
                if(commandCheck.getCommandArgumentsFromCommandLine()[1].contains("--dirname")){
                    data.setFileName(commandCheck.getOptionalParams().get("--filename"));
                    data.setDirName (commandCheck.getCommandArgumentsFromCommandLine()[1]);

                }else{
                    data.setFileName (getFileName(commandCheck.getCommandArgumentsFromCommandLine()[1]));
                    data.setDirName(commandCheck.getOptionalParams().get("--dirname"));
                }
            }else{
                data.setFileName(commandCheck.getOptionalParams().get("--filename"));
                data.setDirName(commandCheck.getOptionalParams().get("--dirname"));
            }
        }
        return data;
    }

    public Data addArgumentsIntoFind()throws Exception{
        data = new Data();
        data.setName(getName(commandCheck.getCommandArgumentsFromCommandLine()[1]));
        if(isOptionalNull()) {
            data.setFileName(getFileName(commandCheck.getCommandArgumentsFromCommandLine()[2]));
            data.setDirName(getFileDir(commandCheck.getCommandArgumentsFromCommandLine()[3]));
        } else{
            if(countArguments(commandCheck.getCommandArgumentsFromCommandLine()) == 2){
                data.setFileName(commandCheck.getOptionalParams().get("--filename"));
                data.setDirName(commandCheck.getOptionalParams().get("--dirname"));
            }
            if(countArguments(commandCheck.getCommandArgumentsFromCommandLine()) == 3){
                if(getFileName(commandCheck.getCommandArgumentsFromCommandLine()[2] )== null){
                    data.setFileName(commandCheck.getOptionalParams().get("--filename"));
                    data.setDirName(getFileDir(commandCheck.getCommandArgumentsFromCommandLine()[2]));
                }else{
                    data.setFileName(getFileName(commandCheck.getCommandArgumentsFromCommandLine()[2]));
                    data.setDirName(commandCheck.getOptionalParams().get("--dirname"));
                }
            }
            if(countArguments(commandCheck.getCommandArgumentsFromCommandLine()) == 4){
                data.setFileName(getFileName(commandCheck.getCommandArgumentsFromCommandLine()[2]));
                data.setDirName(getFileDir(commandCheck.getCommandArgumentsFromCommandLine()[3]));
            }
        }
        return data;
    }

    public int countArguments(String arguments[]){
        return arguments.length;
    }

    public static boolean checkNameSymbol(String str) {
        Pattern p = Pattern.compile("^--name=+[a-zA-ZА-Яа-я]{3,15}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public String getName(String str) throws DataFormatException {
        String returnName = "";
        if (checkNameSymbol(str)) {
            for (String value : str.split("=")) {
                returnName = value;
            }
            return returnName;
        } else {
            throw new DataFormatException();
       }
    }

    public static boolean checkPhoneSymbol(String str) {
        Pattern p = Pattern.compile("^--phone=+[0-9]{3,20}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public String getPhone(String str) throws DataFormatException {
        if (checkPhoneSymbol(str)) {
            String returnPhone = "";
            for (String value : str.split("=")) {
                returnPhone = value;
            }
            return returnPhone;
        } else {
            throw new DataFormatException();
        }
    }

    public static boolean checkFileName(String str) {
        Pattern p = Pattern.compile("\\[--filename=.+\\.txt\\]");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public String getFileName(String str) throws DataFormatException {
        if (checkFileName(str)) {
            String returnFileName = "";
            for (String value : str.split("=")) {
                returnFileName = value;
            }
            return returnFileName.substring(0, returnFileName.length() - 1);
        } else {
            throw new DataFormatException();
        }
    }

    public static boolean checkFileDir(String str) {
        Pattern p = Pattern.compile("\\[--dirname=+[a-zA-ZА-Яа-я0-9]{3,15}\\]");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public String getFileDir(String str) throws DataFormatException {

        if (checkFileDir(str)) {
            String returnFileDir = "";
            for (String value : str.split("=")) {
                returnFileDir = value;
            }
            return returnFileDir.substring(0, returnFileDir.length() - 1);
        } else {
            throw new DataFormatException();
        }
    }
}

