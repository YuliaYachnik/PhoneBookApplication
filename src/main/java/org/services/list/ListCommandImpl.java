package org.services.list;

import org.date.DataObjectWorking;
import org.fileworking.FileWorker;
import org.services.Command;
import java.io.IOException;
import java.util.ArrayList;

public class ListCommandImpl implements Command{
    private ArrayList<DataObjectWorking> personListOut = new ArrayList<DataObjectWorking>();

    public void execute(DataObjectWorking objectClass) throws IOException{
        FileWorker fileWorker = new FileWorker();
        personListOut = fileWorker.readFile(objectClass);
        if (personListOut.size() != 0) {
            for (int i = 0; i < personListOut.size(); i++) {
                System.out.println(personListOut.get(i));
            }
        } else
            System.out.println("No data found! Please, use help-manager.");
    }
}
