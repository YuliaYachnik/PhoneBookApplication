package org.services.add;

import org.date.Data;
import org.fileworking.FileWorker;
import org.parsing.ParseArguments;

import java.util.ArrayList;

public class CommandAddDefinition {

    private ArrayList<Data> person = new ArrayList<Data>();

    public void add(ParseArguments parseArguments) {
        try {
            if (parseArguments == null)
                throw new Exception();
            else {
                Data data = new Data(parseArguments.getName(), parseArguments.getPhone(), parseArguments.getFile(), parseArguments.getFiledir());
                person.add(data);
                FileWorker fileWorker = new FileWorker();
                fileWorker.writeFile(data);

            }
        } catch (Exception e) {
            System.out.println("Check the data! Please, use help-manager.");
            return;
        }

    }
}
