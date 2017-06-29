package org.fileworking;

import org.date.PhoneBookData;
import org.date.SetGetObject;

import java.io.*;
import java.util.ArrayList;

public class FileWorker {
    private String pass = "E:/";

    public void writeFile(SetGetObject objectClass) throws IOException {
       File folder = new File(pass + objectClass.getDir());
        if (!folder.exists()){
            folder.mkdir();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(folder + File.separator + objectClass.getFile(), true);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
        try {
            bufferedWriter.append(objectClass.getName());
            bufferedWriter.append(" - ");
            bufferedWriter.append(objectClass.getPhone());
            bufferedWriter.newLine();
        } finally {
                bufferedWriter.close();
                fileOutputStream.close();
            System.out.println("Successful add to Phonebook");
        }
    }

    public ArrayList<SetGetObject> readFile(SetGetObject objectClass) throws IOException{
        File folder = new File(pass + objectClass.getDir() + File.separator + objectClass.getFile());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(folder));
        try {
            ArrayList<SetGetObject> personList = new ArrayList<SetGetObject>();
            ArrayList<String> str = new ArrayList<String>();
            if (!folder.exists()) throw new FileNotFoundException();
            String buf;
            while ((buf = bufferedReader.readLine()) != null) {
                str = parseStringtoArray(buf);
                if (str != null) {
                    objectClass.setParams(str.get(0), str.get(1), objectClass.getFile(), objectClass.getDir());
                    personList.add(objectClass);
                }
            }
            return personList;
        } finally {
            bufferedReader.close();
        }
    }

   public ArrayList<SetGetObject> findInFile(SetGetObject objectClass) throws IOException{
        File folder = new File(pass + objectClass.getDir() + File.separator + objectClass.getFile());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(folder));
        try {
            ArrayList<SetGetObject> personList = new ArrayList<SetGetObject>();
            ArrayList<String> str = new ArrayList<String>();
            if (!folder.exists()) throw new FileNotFoundException();
            String buf;
            while ((buf = bufferedReader.readLine()) != null) {
                str = parseStringtoArrayWithFind(buf, objectClass.getName());
                if (str != null) {
                    objectClass.setParams(str.get(0), str.get(1), objectClass.getFile(), objectClass.getDir());
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
