package org.check;

import org.date.SetGetObject;
import org.services.CommandCheckImpl;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

public class CheckManager {
    private CommandCheckImpl commandCheck;
    private SetGetObject setGetObject;

    public CheckManager(CommandCheckImpl commandCheck, SetGetObject setGetObject) {
        this.commandCheck = commandCheck;
        this.setGetObject = setGetObject;
    }

    public SetGetObject returnValidateObject() throws Exception {
        if(commandCheck.check(commandCheck.getParametrDefinitions(),commandCheck.getOptionalParams(),commandCheck.getCommandArgumentsFromCommandLine())){
            parseArguments();
            return setGetObject;
        }else {
            throw new DataFormatException();
        }
    }

    public SetGetObject parseArguments() throws DataFormatException, ArrayIndexOutOfBoundsException,
            InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        String name = null;
        String phone = null;
        String file, dir;
        String filedir[];
       for(int i = 0; i < commandCheck.getParametrDefinitions().size(); i++){
            if(commandCheck.getParametrDefinitions().get(i).isMandatory()){
                if(commandCheck.getParametrDefinitions().get(i).getName().contains("name")){
                    name = (getName(commandCheck.getCommandArgumentsFromCommandLine()[i+1]));
                } else
                   phone = (getPhone(commandCheck.getCommandArgumentsFromCommandLine()[i+1]));
            }else{
               if(commandCheck.getCommandArgumentsFromCommandLine().length > commandCheck.getParametrDefinitions().size()){
                   filedir  = OptionalInCommandLine();
                   file = filedir[0]; dir = filedir[1];
                   setGetObject.setParams(name,phone,file,dir);
                   return setGetObject;

               } else{
                   filedir  =  NotOptionalInCommandLine();
                   file = filedir[0]; dir = filedir[1];
                   setGetObject.setParams(name,phone,file,dir);
                   return setGetObject;
               }
            }
        }
        return setGetObject;
    }

    public String[] NotOptionalInCommandLine() throws DataFormatException{
        String filedir[] = new String[2];
        for(int i = 0;i < commandCheck.getParametrDefinitions().size(); i++){
            if(!commandCheck.getParametrDefinitions().get(i).isMandatory()){
                if(commandCheck.getParametrDefinitions().get(i).getName().contains("filename"))
                   filedir[0] = (commandCheck.getOptionalParams().get("--filename"));
                else
                    filedir[1]  = (commandCheck.getOptionalParams().get("--dirname"));
            }
        }
        return filedir;
    }
    public String[] OptionalInCommandLine() throws DataFormatException{
        String filedir[] = new String[2];
        for(int i = 0;i < commandCheck.getParametrDefinitions().size(); i++){
            if(!commandCheck.getParametrDefinitions().get(i).isMandatory()){
                if(commandCheck.getParametrDefinitions().get(i).getName().contains("filename"))
                    filedir[0] =  (getFileName(commandCheck.getCommandArgumentsFromCommandLine()[i+1]));
                else
                    filedir[1] = (getFileDir(commandCheck.getCommandArgumentsFromCommandLine()[i+1]));}
            }
        return filedir;
    }

    public static boolean checkNameSymbol(String str) {
        Pattern p = Pattern.compile("^--[a-zA-ZА-Яа-я]{3,15}=[a-zA-ZА-Яа-я]{3,15}$");
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
        Pattern p = Pattern.compile("^--[a-zA-ZА-Яа-я]{3,15}=[0-9]{3,20}$");
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

