package org.services.find;

import org.date.DataObjectWorking;
import org.fileworking.FileWorker;
import org.services.Command;
import java.io.IOException;
import java.util.ArrayList;

public class FindCommandImpl implements Command{
    private ArrayList<DataObjectWorking> classArrayList = new ArrayList<>();

    public void execute(DataObjectWorking objectClass) throws IOException{
            FileWorker fileWorker = new FileWorker();
            classArrayList = fileWorker.findInFile(objectClass);
            if (classArrayList.size() != 0) {
                for (int i = 0; i < classArrayList.size(); i++) {
                    System.out.println(classArrayList.get(i));
                }
            } else System.out.println("No data found! Please, use help-manager.");
    }
}


