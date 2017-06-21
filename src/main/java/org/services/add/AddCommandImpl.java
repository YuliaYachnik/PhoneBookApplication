package org.services.add;

import org.parsing.ParseArguments;
import org.services.Command;
import org.services.checker.AddCommandCheckImpl;
import org.services.checker.Check;

/**
 * Created by Юлия on 16.06.2017.
 */
public class AddCommandImpl implements Command {
    private AddCommandCheckImpl addCommandCheck;
    private AddCommandReceiver addCommandReceiver;
    private String args[];


    public AddCommandImpl(){
        addCommandReceiver = new AddCommandReceiver();
        addCommandCheck = new AddCommandCheckImpl();
    }

    public void execute() {
        if(addCommandCheck.check(args)!= null)
         addCommandReceiver.add();

    }
}
