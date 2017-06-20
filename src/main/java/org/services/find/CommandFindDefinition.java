package org.services.find;

import org.date.Data;
import org.fileworking.FileWorker;
import org.parsing.ParseArguments;
import java.util.ArrayList;

/**
 * Created by Юлия on 16.06.2017.
 */
public class CommandFindDefinition {
    private ArrayList<Data> personFindOut = new ArrayList<Data>();

    public void find(ParseArguments parseArguments) {
        try {
            if (parseArguments == null)
                throw new Exception();
            else {
                String filename = parseArguments.getFile();
                String dirname = parseArguments.getFiledir();
                String name = parseArguments.getName();
                FileWorker fileWorker = new FileWorker();
                personFindOut = fileWorker.findInFile(name, filename, dirname);
                if (personFindOut.size() != 0) {
                    for (int i = 0; i < personFindOut.size(); i++) {
                        System.out.println(personFindOut.get(i));
                    }
                } else
                    System.out.println("No data found! Please, use help-manager.");
            }

        } catch (Exception e) {
            System.out.println("No data found! Please, use help-manager.");
            return;
        }

    }
}
