package org.services.find;

import org.date.Data;
import org.fileworking.FileWorker;
import org.services.Command;


import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Юлия on 16.06.2017.
 */
public class FindCommandImpl implements Command{
    private ArrayList<Data> personFindOut = new ArrayList<Data>();

    public void execute(Data data) throws FileNotFoundException{
        try {
            FileWorker fileWorker = new FileWorker();
            personFindOut = fileWorker.findInFile(data);
            if (personFindOut.size() != 0) {
                for (int i = 0; i < personFindOut.size(); i++) {
                    System.out.println(personFindOut.get(i));
                }
            } else System.out.println("No data found! Please, use help-manager.");
        }catch (FileNotFoundException e){
            System.out.println("File not found!");
        }catch (UnsupportedEncodingException e){
            System.out.println("Unsupported Encoding!");
        }
    }

    }


