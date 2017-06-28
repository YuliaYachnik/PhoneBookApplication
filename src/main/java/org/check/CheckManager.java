package org.check;

import org.date.Data;
import org.services.CommandCheckImpl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

public class CheckManager {
    private CommandCheckImpl commandCheck;
    private Data data;

    public CheckManager(CommandCheckImpl commandCheck) {
        this.commandCheck = commandCheck;
    }

    public Data returnValidateObject() throws Exception {
        if(commandCheck.check(commandCheck.getParametrDefinitions(),commandCheck.getOptionalParams(),commandCheck.getCommandArgumentsFromCommandLine())){
            parseArguments();
            return data;
        }else {
            throw new DataFormatException();
        }
    }

    public Data parseArguments() throws DataFormatException, ArrayIndexOutOfBoundsException{
        data = new Data();
        for(int i = 0; i < commandCheck.getParametrDefinitions().size(); i++){
            if(commandCheck.getParametrDefinitions().get(i).isMandatory()){
                if(commandCheck.getParametrDefinitions().get(i).getName().contains("name"))
                 data.setName(getName(commandCheck.getCommandArgumentsFromCommandLine()[i+1]));
                else
                    data.setPhone(getPhone(commandCheck.getCommandArgumentsFromCommandLine()[i+1]));
            }else{
               if(commandCheck.getCommandArgumentsFromCommandLine().length > commandCheck.getParametrDefinitions().size())
                   OptionalInCommandLine();
                else
                    NotOptionalInCommandLine();
            }
        }
        return data;
    }

    public Data NotOptionalInCommandLine() throws DataFormatException{
        for(int i = 0;i < commandCheck.getParametrDefinitions().size(); i++){
            if(!commandCheck.getParametrDefinitions().get(i).isMandatory()){
                if(commandCheck.getParametrDefinitions().get(i).getName().contains("filename"))
                    data.setFileName(commandCheck.getOptionalParams().get("--filename"));
                else
                    data.setDirName(commandCheck.getOptionalParams().get("--dirname"));
            }
        }
        return data;
    }
    public Data OptionalInCommandLine() throws DataFormatException{
        for(int i = 0;i < commandCheck.getParametrDefinitions().size(); i++){
            if(!commandCheck.getParametrDefinitions().get(i).isMandatory()){
                if(commandCheck.getParametrDefinitions().get(i).getName().contains("filename"))
                    data.setFileName(getFileName(commandCheck.getCommandArgumentsFromCommandLine()[i+1]));
                else
                    data.setDirName(getFileDir(commandCheck.getCommandArgumentsFromCommandLine()[i+1]));}
            }
        return data;
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

