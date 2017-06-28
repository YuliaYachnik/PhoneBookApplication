package org.services.add;

import org.date.Data;
import org.fileworking.FileWorker;
import org.services.Command;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddCommandImpl implements Command {

    public void execute(Data data) throws IOException{
        List<Data> persons = new ArrayList<>();
        persons.add(data);
        FileWorker fileWorker = new FileWorker();
        fileWorker.writeFile(data);
    }
}




