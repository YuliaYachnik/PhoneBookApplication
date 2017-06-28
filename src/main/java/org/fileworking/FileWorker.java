package org.fileworking;

import org.date.PhoneBookData;
import org.date.PrintObject;

import java.io.*;
import java.util.ArrayList;

public class FileWorker {
    private String pass = "E:/";

    public void writeFile(Class <PrintObject> objectClass) throws IOException {
        File folder = new File(pass + phoneBookData.getDirName());
        if (!folder.exists()){
            folder.mkdir();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(folder + File.separator + phoneBookData.getFileName(), true);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
        try {
            bufferedWriter.append(phoneBookData.getName());
            bufferedWriter.append(" - ");
            bufferedWriter.append(phoneBookData.getPhone());
            bufferedWriter.newLine();
        } finally {
                bufferedWriter.close();
                fileOutputStream.close();
            System.out.println("Successful add to Phonebook");
        }
    }

    public ArrayList<PhoneBookData> readFile(String fileName, String dirName) throws IOException{
        File folder = new File(pass + dirName + File.separator + fileName);
        PhoneBookData phoneBookData;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(folder));
        try {
            ArrayList<PhoneBookData> personList = new ArrayList<PhoneBookData>();
            ArrayList<String> str = new ArrayList<String>();
            if (!folder.exists()) throw new FileNotFoundException();
            String buf;
            while ((buf = bufferedReader.readLine()) != null) {
                str = parseStringtoArray(buf);
                if (str != null) {
                    phoneBookData = new PhoneBookData(str.get(0), str.get(1), fileName, dirName);
                    personList.add(phoneBookData);
                }
            }
            return personList;
        } finally {
            bufferedReader.close();
        }
    }

    public ArrayList<Class<PrintObject>> findInFile(Class <PrintObject> objectClass) throws IOException{
        File folder = new File(pass + phoneBookData.getDirName() + File.separator + phoneBookData.getFileName());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(folder));
        try {
            PhoneBookData finddata;
            ArrayList<PhoneBookData> personList = new ArrayList<PhoneBookData>();
            ArrayList<String> str = new ArrayList<String>();
            if (!folder.exists()) throw new FileNotFoundException();
            String buf;
            while ((buf = bufferedReader.readLine()) != null) {
                str = parseStringtoArrayWithFind(buf, phoneBookData.getName());
                if (str != null) {
                    finddata = new PhoneBookData(str.get(0), str.get(1), phoneBookData.getFileName(), phoneBookData.getDirName());
                    personList.add(finddata);
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
