package org.services.list;

import org.date.PhoneBookData;
import org.date.PrintObject;
import org.fileworking.FileWorker;
import org.services.Command;
import java.io.IOException;
import java.util.ArrayList;

public class ListCommandImpl implements Command{
    private ArrayList<PhoneBookData> personListOut = new ArrayList<PhoneBookData>();

    public void execute(Class <PrintObject> objectClass) throws IOException{
        String filename = objectClass.getFileName();
        String dirname = objectClass.getDirName();
        FileWorker fileWorker = new FileWorker();
        personListOut = fileWorker.readFile(filename, dirname);
        if (personListOut.size() != 0) {
            for (int i = 0; i < personListOut.size(); i++) {
                System.out.println(personListOut.get(i));
            }
        } else
            System.out.println("No phoneBookData found! Please, use help-manager.");
    }
}
