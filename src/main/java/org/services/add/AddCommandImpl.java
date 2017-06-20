package org.services.add;

import org.parsing.ParseArguments;
import org.services.Command;

/**
 * Created by Юлия on 16.06.2017.
 */
public class AddCommandImpl implements Command{
    private AddCommandReceiver addCommandReceiver;
    private  ParseArguments parseArguments;

    public AddCommandImpl(ParseArguments parseArguments, AddCommandReceiver addCommandReceiver){
        this.parseArguments = parseArguments;
        this.addCommandReceiver = addCommandReceiver;
    }

    public AddCommandImpl(){}

    public void execute() {
        if(parseArguments != null) addCommandReceiver.add(parseArguments);

    }
}
