package org.services.find;

import org.parsing.ParseArguments;
import org.services.Command;

/**
 * Created by Юлия on 16.06.2017.
 */
public class FindCommandImpl implements Command {
    private FindCommandReceiver findCommandReceiver;
    private FindCommandCheckImpl findCommandCheck;
    private ParseArguments parseArguments;
    private String args[];

    public FindCommandImpl() {
        this.findCommandReceiver = new FindCommandReceiver();
        this.findCommandCheck = new FindCommandCheckImpl();
    }

    public void execute() {
        if(findCommandCheck.check(args) != null)
            findCommandReceiver.find(parseArguments);
    }

}
