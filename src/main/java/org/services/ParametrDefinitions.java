package org.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Юлия on 19.06.2017.
 */
public class ParametrDefinitions {
    private String name;
    private boolean isOptional;

    public ParametrDefinitions(){}

    public ParametrDefinitions(String name, boolean isOptional) {
        this.name = name;
        this.isOptional = isOptional;
    }

  /*  public static boolean checkNameSymbol(String str) {
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

    public ParametrDefinitions parseParematrs(String args[]){
*/
    }


