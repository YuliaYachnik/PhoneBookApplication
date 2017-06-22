package org.services.add;

import org.services.Command;
import org.services.CommandDefinition;
import org.services.add.checkAdd.AddCommandCheckImpl;

import java.util.Map;

/**
 * Created by Юлия on 16.06.2017.
 */
public class AddCommandImpl implements Command {
    private AddCommandCheckImpl addCommandCheck;
    private AddCommandReceiver addCommandReceiver;
   // private String args[];


    public AddCommandImpl(){
        addCommandReceiver = new AddCommandReceiver();
        addCommandCheck = new AddCommandCheckImpl();
    }

    public void execute(Map<String,String> map,String args[]) {
         addCommandReceiver.add(addCommandCheck.check(map,args));
    }
}
