package org.services;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Юлия on 20.06.2017.
 */
public class CommandCheckImpl implements Check {
    private List<ParametrDefinitions> parametrDefinitions;
    private Map<String,String> optionalParams;
    private String[] commandArgumentsFromCommandLine;

    public CommandCheckImpl() {
    }

    public CommandCheckImpl(List<ParametrDefinitions> parametrDefinitions, Map<String,String> optionalParams, String[] commandArgumentsFromCommandLine) {
        this.parametrDefinitions = parametrDefinitions;
        this.optionalParams = optionalParams;
        this.commandArgumentsFromCommandLine = commandArgumentsFromCommandLine;
    }

    public List<ParametrDefinitions> getParametrDefinitions() {
        return parametrDefinitions;
    }

    public String[] getCommandArgumentsFromCommandLine() {
        return commandArgumentsFromCommandLine;
    }

    public Map<String, String> getOptionalParams() {
        return optionalParams;
    }

    @Override
    public boolean check(List<ParametrDefinitions> parametrDefinitions,Map<String,String> optionalParams, String args[]) {
            if (parametrDefinitions == null || args == null || args.length > 5){
                throw new NullPointerException("Parametrs are not valid! Please, use help-manager");
            } else{
               if( chooseVersionOfParsing(getNameOfMethod())== true) return true;
                return false;
            }
    }

    private boolean checkMatchingOptionalAndArgsParametr(){
       if((getCommandArgumentsFromCommandLine().length == getMandatryArguments() + 1) && getOptionalParams() == null)
           return false;
       if((getCommandArgumentsFromCommandLine().length ==  getMandatryArguments() + 2 )&& getOptionalParams() == null)
           return false;
       if(getCommandArgumentsFromCommandLine().length > getMandatryArguments() + 1)
           return true;
        else return false;
    }

/*    private boolean checkMatchingOptionalAndArgsParametrInFind(){
        if((getCommandArgumentsFromCommandLine().length == getMandatryArguments() + 1) && getOptionalParams() == null)
            return false;
        if(getCommandArgumentsFromCommandLine().length ==  getMandatryArguments() + 2 && getOptionalParams() == null)
            return false;
        if((getCommandArgumentsFromCommandLine().length >=  getMandatryArguments() + 1) && getCommandArgumentsFromCommandLine().length < 5) return true;
        else return false;}*/

    private int getMandatryArguments(){
        int mandatoryCount = 0;
        for(int i = 0; i < getParametrDefinitions().size(); i++){
            if(getParametrDefinitions().get(i).isMandatory() == true)  mandatoryCount++;
        }
        if(mandatoryCount != 0)
            return mandatoryCount;
        else
            throw new RuntimeException("Initializing parameters error. Please, use help-manager.");
    }

    private String getNameOfMethod(){
        String name = getCommandArgumentsFromCommandLine()[0];
        return name;
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

    private  boolean chooseVersionOfParsing(String nameOfMethod){
        if(nameOfMethod.equals("add")) return checkMatchingOptionalAndArgsParametr();
        if(nameOfMethod.equals("find")) return checkMatchingOptionalAndArgsParametr();
        if(nameOfMethod.equals("list")){
            //проверка параметров на list
        }else{
            //проверка параметров на help
        }
        return true;
    }


}
