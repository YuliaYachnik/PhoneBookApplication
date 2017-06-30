package org.fileworking;

import org.date.DataObjectWorking;

import java.io.*;
import java.util.ArrayList;

public class FileWorker {
    private String pass = "E:/";

    public void writeFile(DataObjectWorking objectClass) throws IOException {
       File folder = new File(pass + objectClass.getField4());
        if (!folder.exists()){
            folder.mkdir();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(folder + File.separator + objectClass.getField3(), true);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
        try {
            bufferedWriter.append(objectClass.getField1());
            bufferedWriter.append(" - ");
            bufferedWriter.append(objectClass.getField2());
            bufferedWriter.newLine();
        } finally {
                bufferedWriter.close();
                fileOutputStream.close();
            System.out.println("Successful add to the directory");
        }
    }

    public ArrayList<DataObjectWorking> readFile(DataObjectWorking objectClass) throws IOException{
        File folder = new File(pass + objectClass.getField4() + File.separator + objectClass.getField3());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(folder));
        try {
            ArrayList<DataObjectWorking> personList = new ArrayList<DataObjectWorking>();
            ArrayList<String> str = new ArrayList<String>();
            if (!folder.exists()) throw new FileNotFoundException();
            String buf;
            while ((buf = bufferedReader.readLine()) != null) {
                str = parseStringtoArray(buf);
                if (str != null) {
                    objectClass.setParams(str.get(0), str.get(1), objectClass.getField3(), objectClass.getField4());
                    personList.add(objectClass);
                }
            }
            return personList;
        } finally {
            bufferedReader.close();
        }
    }

   public ArrayList<DataObjectWorking> findInFile(DataObjectWorking objectClass) throws IOException{
        File folder = new File(pass + objectClass.getField4() + File.separator + objectClass.getField3());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(folder));
        try {
            ArrayList<DataObjectWorking> personList = new ArrayList<DataObjectWorking>();
            ArrayList<String> str = new ArrayList<String>();
            if (!folder.exists()) throw new FileNotFoundException();
            String buf;
            while ((buf = bufferedReader.readLine()) != null) {
                str = parseStringtoArrayWithFind(buf, objectClass.getField1());
                if (str != null) {
                    objectClass.setParams(str.get(0), str.get(1), objectClass.getField3(), objectClass.getField4());
                    personList.add(objectClass);
                }
            }
            return personList;
        }  finally {
                bufferedReader.close();
        }
    }


    public ArrayList<String> parseStringtoArrayWithFind(String str, String name) {
        ArrayList<String> strings = new ArrayList<String>();
        for (String returnValue : str.split(" - ", 2)) {
            strings.add(returnValue);
        }
        if (strings.get(0).equals(name) || strings.get(0).contains(name))
            return strings;
        else
            return null;
    }

    public ArrayList<String> parseStringtoArray(String str) {
        ArrayList<String> strings = new ArrayList<String>();
        for (String returnValue : str.split(" - ", 2)) {
            strings.add(returnValue);
        }
        return strings;
    }
}
