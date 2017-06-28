package org.check;

import org.date.PhoneBookData;
import org.date.PrintObject;
import org.services.CommandCheckImpl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

public class CheckManager {
    private CommandCheckImpl commandCheck;
    private Class<PrintObject> objectClass;

    public CheckManager(CommandCheckImpl commandCheck) {
        this.commandCheck = commandCheck;
    }

    public Class<PrintObject> returnValidateObject() throws Exception {
        if(commandCheck.check(commandCheck.getParametrDefinitions(),commandCheck.getOptionalParams(),commandCheck.getCommandArgumentsFromCommandLine())){
            parseArguments();
            return objectClass;
        }else {
            throw new DataFormatException();
        }
    }

    public Class<PrintObject> parseArguments() throws DataFormatException, ArrayIndexOutOfBoundsException{
        objectClass = new PhoneBookData();
        for(int i = 0; i < commandCheck.getParametrDefinitions().size(); i++){
            if(commandCheck.getParametrDefinitions().get(i).isMandatory()){
                if(commandCheck.getParametrDefinitions().get(i).getName().contains("name"))
                 objectClass.setName(getName(commandCheck.getCommandArgumentsFromCommandLine()[i+1]));
                else
                    objectClass.setPhone(getPhone(commandCheck.getCommandArgumentsFromCommandLine()[i+1]));
            }else{
               if(commandCheck.getCommandArgumentsFromCommandLine().length > commandCheck.getParametrDefinitions().size())
                   OptionalInCommandLine();
                else
                    NotOptionalInCommandLine();
            }
        }
        return objectClass;
    }

    public Class<PrintObject> NotOptionalInCommandLine() throws DataFormatException{
        for(int i = 0;i < commandCheck.getParametrDefinitions().size(); i++){
            if(!commandCheck.getParametrDefinitions().get(i).isMandatory()){
                if(commandCheck.getParametrDefinitions().get(i).getName().contains("filename"))
                    objectClass.setFileName(commandCheck.getOptionalParams().get("--filename"));
                else
                    objectClass.setDirName(commandCheck.getOptionalParams().get("--dirname"));
            }
        }
        return objectClass;
    }
    public Class<PrintObject> OptionalInCommandLine() throws DataFormatException{
        for(int i = 0;i < commandCheck.getParametrDefinitions().size(); i++){
            if(!commandCheck.getParametrDefinitions().get(i).isMandatory()){
                if(commandCheck.getParametrDefinitions().get(i).getName().contains("filename"))
                    objectClass.setFileName(getFileName(commandCheck.getCommandArgumentsFromCommandLine()[i+1]));
                else
                    objectClass.setDirName(getFileDir(commandCheck.getCommandArgumentsFromCommandLine()[i+1]));}
            }
        return objectClass;
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

