package org.services.add;

import org.date.Data;
import org.fileworking.FileWorker;
import org.services.CheckManager;
import org.services.Command;
import org.services.CommandCheckImpl;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 16.06.2017.
 */
public class AddCommandImpl implements Command {

    public void execute(Data data) { //передавать объект с валидными полями
        List<Data> persons = new ArrayList<>();
        persons.add(data);
        FileWorker fileWorker = new FileWorker();
        try {
            fileWorker.writeFile(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}




