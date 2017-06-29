package org.services.list;

import org.date.SetGetObject;
import org.fileworking.FileWorker;
import org.services.Command;
import java.io.IOException;
import java.util.ArrayList;

public class ListCommandImpl implements Command{
    private ArrayList<SetGetObject> personListOut = new ArrayList<SetGetObject>();

    public void execute(SetGetObject objectClass) throws IOException{
        FileWorker fileWorker = new FileWorker();
        personListOut = fileWorker.readFile(objectClass);
        if (personListOut.size() != 0) {
            for (int i = 0; i < personListOut.size(); i++) {
                System.out.println(personListOut.get(i));
            }
        } else
            System.out.println("No phoneBookData found! Please, use help-manager.");
    }
}
