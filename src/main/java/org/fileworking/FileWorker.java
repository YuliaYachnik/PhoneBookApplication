package org.fileworking;

import org.date.Data;
import java.io.*;
import java.util.ArrayList;

public class FileWorker {
    private String pass = "E:/";

    public void writeFile(Data data) throws IOException {
        File folder = new File(pass + data.getDirName());
        if (!folder.exists()){
            folder.mkdir();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(folder + File.separator + data.getFileName(), true);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
        try {
            bufferedWriter.append(data.getName());
            bufferedWriter.append(" - ");
            bufferedWriter.append(data.getPhone());
            bufferedWriter.newLine();
        } finally {
                bufferedWriter.close();
                fileOutputStream.close();
        }
    }

    public ArrayList<Data> readFile(String fileName, String dirName) throws IOException{
        File folder = new File(pass + dirName + File.separator + fileName);
        Data data;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(folder));
        try {
            ArrayList<Data> personList = new ArrayList<Data>();
            ArrayList<String> str = new ArrayList<String>();
            if (!folder.exists()) throw new FileNotFoundException();
            String buf;
            while ((buf = bufferedReader.readLine()) != null) {
                str = parseStringtoArray(buf);
                if (str != null) {
                    data = new Data(str.get(0), str.get(1), fileName, dirName);
                    personList.add(data);
                }
            }
            return personList;
        } finally {
            bufferedReader.close();
        }
    }

    public ArrayList<Data> findInFile(Data data) throws IOException{
        File folder = new File(pass + data.getDirName() + File.separator + data.getFileName());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(folder));
        try {
            Data finddata;
            ArrayList<Data> personList = new ArrayList<Data>();
            ArrayList<String> str = new ArrayList<String>();
            if (!folder.exists()) throw new FileNotFoundException();
            String buf;
            while ((buf = bufferedReader.readLine()) != null) {
                str = parseStringtoArrayWithFind(buf, data.getName());
                if (str != null) {
                    finddata = new Data(str.get(0), str.get(1), data.getFileName(), data.getDirName());
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
