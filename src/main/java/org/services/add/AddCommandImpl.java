package org.services.add;

import org.date.PhoneBookData;
import org.date.PrintObject;
import org.fileworking.FileWorker;
import org.services.Command;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddCommandImpl implements Command {

    public void execute(Class <PrintObject> objectClass) throws IOException{
        List<Class <PrintObject>> persons = new ArrayList<>();
        persons.add(objectClass);
        FileWorker fileWorker = new FileWorker();
        fileWorker.writeFile(objectClass);
    }
}




