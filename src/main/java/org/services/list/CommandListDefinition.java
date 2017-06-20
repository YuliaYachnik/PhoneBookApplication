package org.services.list;

import org.date.Data;
import org.fileworking.FileWorker;
import org.parsing.ParseArguments;
import java.util.ArrayList;

/**
 * Created by Юлия on 16.06.2017.
 */
public class CommandListDefinition {
     private ArrayList<Data> personListOut = new ArrayList<Data>();

    public void list(ParseArguments parseArguments) {
        try {
            if (parseArguments == null)
                throw new Exception();
            else {
                String filename = parseArguments.getFile();
                String dirname = parseArguments.getFiledir();
                FileWorker fileWorker = new FileWorker();
                personListOut = fileWorker.readFile(filename, dirname);
                if (personListOut.size() != 0) {
                    for (int i = 0; i < personListOut.size(); i++) {
                        System.out.println(personListOut.get(i));
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
