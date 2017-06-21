package org.services.add;

import org.date.Data;
import org.fileworking.FileWorker;
import org.parsing.ParseArguments;

import java.util.ArrayList;

public class AddCommandReceiver {

    private ArrayList<Data> person = new ArrayList<Data>();

    public void add() {
        try {
         //   if (parseArguments == null)
           //     throw new Exception();
           // else {
                Data data = new Data("1","2","3","4");
                person.add(data);
                FileWorker fileWorker = new FileWorker();
                fileWorker.writeFile(data);

        //    }
        } catch (Exception e) {
            System.out.println("Check the data! Please, use help-manager.");
            return;
        }

    }
}
