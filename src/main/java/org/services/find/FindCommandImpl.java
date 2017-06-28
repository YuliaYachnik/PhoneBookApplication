package org.services.find;

import org.date.PhoneBookData;
import org.date.PrintObject;
import org.fileworking.FileWorker;
import org.services.Command;
import java.io.IOException;
import java.util.ArrayList;

public class FindCommandImpl implements Command{
    private ArrayList<Class <PrintObject> > classArrayList = new ArrayList<>();

    public void execute(Class <PrintObject> objectClass) throws IOException{
            FileWorker fileWorker = new FileWorker();
            classArrayList = fileWorker.findInFile(objectClass);
            if (classArrayList.size() != 0) {
                for (int i = 0; i < classArrayList.size(); i++) {
                    System.out.println(classArrayList.get(i));
                }
            } else System.out.println("No phoneBookData found! Please, use help-manager.");
    }
}


