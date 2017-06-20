package org.fileworking;

import org.date.Data;
import java.io.*;
import java.util.ArrayList;

public class FileWorker {
    private String pass = "E:/";

    public void writeFile(Data data) throws FileNotFoundException, UnsupportedEncodingException {
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
        } catch (IOException e) {
            System.out.println("Error with writing data to file.Please,use help-manager");
        }finally {
            try {
                bufferedWriter.close();
                fileOutputStream.close();
                System.out.println("Successfull writing to file");
            } catch (IOException e) {
                System.out.println("Error with writing data to file. Please,use help-manager");
            }
        }
    }

    public ArrayList<Data> readFile(String fileName, String dirName) throws FileNotFoundException {
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
        } catch (FileNotFoundException e) {
            System.out.println("Not a valid path to file.Please,use help-manager");
            return null;
        } catch (IOException ex) {
            System.out.println("Exception with reading from file. Please,use help-manager");
            return null;
        } finally {
            try {
                bufferedReader.close();

            } catch (IOException ex) {
                System.out.println("Exception with reading from file. Please,use help-manager");
                return null;
            }
        }

    }

    public ArrayList<Data> findInFile(String name, String fileName, String dirName) throws FileNotFoundException, UnsupportedEncodingException {
        File folder = new File(pass + dirName + File.separator + fileName);
        Data data;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(folder));
        try {
            ArrayList<Data> personList = new ArrayList<Data>();
            ArrayList<String> str = new ArrayList<String>();
            if (!folder.exists()) throw new FileNotFoundException();
            String buf;
            while ((buf = bufferedReader.readLine()) != null) {
                str = parseStringtoArrayWithFind(buf, name);
                if (str != null) {
                    data = new Data(str.get(0), str.get(1), fileName, dirName);
                    personList.add(data);
                }
            }
            return personList;
        } catch (FileNotFoundException e) {
            System.out.println("Not a valid path to file.Please,use help-manager");
            return null;
        } catch (IOException ex) {
            System.out.println("Exception with reading from file. Please,use help-manager");
            return null;
        } finally {
            try {
                bufferedReader.close();

            } catch (IOException ex) {
                System.out.println("Exception with reading from file. Please,use help-manager");
                return null;
            }
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
