package org.services.list;

import org.date.Data;
import org.fileworking.FileWorker;
import org.services.Command;
import java.io.IOException;
import java.util.ArrayList;

public class ListCommandImpl implements Command{
    private ArrayList<Data> personListOut = new ArrayList<Data>();

    public void execute(Data data) throws IOException{
        String filename = data.getFileName();
        String dirname = data.getDirName();
        FileWorker fileWorker = new FileWorker();
        personListOut = fileWorker.readFile(filename, dirname);
        if (personListOut.size() != 0) {
            for (int i = 0; i < personListOut.size(); i++) {
                System.out.println(personListOut.get(i));
            }
        } else
            System.out.println("No data found! Please, use help-manager.");
    }
}
