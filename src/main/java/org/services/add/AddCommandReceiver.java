package org.services.add;

import org.date.Data;
import org.fileworking.FileWorker;
import org.parsing.ParseArguments;
import org.services.ParametrDefinitions;

import java.util.ArrayList;
import java.util.List;

public class AddCommandReceiver {
    private ArrayList<Data> person = new ArrayList<Data>();

    public void add(String args[]) {
        try {
                Data data = new Data(args[1],args[2],args[3],args[4]);
                person.add(data);
                FileWorker fileWorker = new FileWorker();
                fileWorker.writeFile(data);
        } catch (Exception e) {
            System.out.println("Check the data! Please, use help-manager.");
            return;
        }
    }
}
