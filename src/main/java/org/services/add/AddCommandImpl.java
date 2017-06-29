package org.services.add;

import org.date.SetGetObject;
import org.fileworking.FileWorker;
import org.services.Command;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class AddCommandImpl implements Command {

    public void execute(SetGetObject objectClass) throws IOException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        List<SetGetObject> persons = new ArrayList<>();
        persons.add(objectClass);
        FileWorker fileWorker = new FileWorker();
        fileWorker.writeFile(objectClass);
    }
}





