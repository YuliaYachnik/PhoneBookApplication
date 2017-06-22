package org.services.add.checkAdd;


import org.services.ParametrDefinitions;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Юлия on 21.06.2017.
 */
public class CheckAddCommandReceiver {
    private List<ParametrDefinitions>  parametrDefinitions;

    public void setParametrDefinitions(List<ParametrDefinitions> parametrDefinitions) {
        this.parametrDefinitions = parametrDefinitions;
    }

    public String[] checkAddCommand( Map<String,String> map, String args[]){
        try {
            String newArgs[] = null;
            if(validCountOfArgs(args) == validCountOfArgsWithOptional(args, map) == true){
                newArgs = setNewArgsWithMap(args, map);
                if(map == null) newArgs = setNewArgsWithoutMap(args);
                return newArgs;
            }else throw new Exception();
        } catch (Exception e) {
            System.out.println("Command Add is not valid! Please, use help-manager");
            System.exit(0);
            return null;
        }
    }
    public boolean validCountOfArgs(String args[]){
        if(args.length > 5 || args.length == 2 || args.length == 4) return false;
        return true;
    }

    public boolean validCountOfArgsWithOptional(String args[],Map<String,String> map){
        if((args.length == 3 && map == null)|| (args.length == 5&& map != null))
            return false;
        return true;
    }

    public String[] setNewArgsWithoutMap(String args[]){
        String newArgs[] = new String[5];
        try {
            newArgs[0] = args[0];
            String name = getName(args[1]);
            newArgs[1] = name;
            String phone = getPhone(args[2]);
            newArgs[2] = phone;
            String file = getFileName(args[3]);
            newArgs[3] = file;
            String dir = getFileDir(args[4]);
            newArgs[4] = dir;
            return newArgs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return args;
    }

    public String[] setNewArgsWithMap(String args[], Map<String,String> map){
        String newArgs[] = new String[5];
        if (map != null) {
            try {
                newArgs[0] = args[0];
                String name = getName(args[1]);
                newArgs[1] = name;
                String phone = getPhone(args[2]);
                newArgs[2] = phone;
                newArgs[3] = map.get("--filename");
                newArgs[4] = map.get("--dirname");
                return newArgs;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
       return args;
    }

    public static boolean checkNameSymbol(String str) {
        Pattern p = Pattern.compile("^--name=+[a-zA-ZА-Яа-я]{3,15}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }
    public String getName(String str) throws Exception {
        try {
            String returnName = "";
            if (checkNameSymbol(str) == true) {
                for (String value : str.split("=")) {
                    returnName = value;
                }
                return returnName;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Incorrect name data.Please,use help-manager.");
            return null;
        }
    }

    public static boolean checkPhoneSymbol(String str) {
        Pattern p = Pattern.compile("^--phone=+[0-9]{3,20}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public String getPhone(String str) throws Exception {
        try {
            if (checkPhoneSymbol(str) == true) {
                String returnPhone = "";
                for (String value : str.split("=")) {
                    returnPhone = value;
                }
                return returnPhone;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Incorrect phone number. Please,use help-manager.");
            return null;
        }
    }

    public static boolean checkFileName(String str) {
        Pattern p = Pattern.compile("\\[--filename=.+\\.txt\\]");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public String getFileName(String str) throws Exception {
        try {
            if (checkFileName(str) == true) {
                String returnFileName = "";
                for (String value : str.split("=")) {
                    returnFileName = value;
                }
                return returnFileName.substring(0, returnFileName.length() - 1);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Incorrect file name. Please,use help-manager.");
            return null;
        }
    }

    public static boolean checkFileDir(String str) {
        Pattern p = Pattern.compile("\\[--dirname=+[a-zA-ZА-Яа-я0-9]{3,15}\\]");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public String getFileDir(String str) throws Exception {
        try {
            if (checkFileDir(str) == true) {
                String returnFileDir = "";
                for (String value : str.split("=")) {
                    returnFileDir = value;
                }
                return returnFileDir.substring(0, returnFileDir.length() - 1);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Incorrect name of directory. Please,use help-manager.");
            return null;
        }
    }

}
