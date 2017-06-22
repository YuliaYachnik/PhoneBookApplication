package org.services.find;

import org.services.Command;
import org.services.CommandDefinition;

import java.util.Map;

/**
 * Created by Юлия on 16.06.2017.
 */
public class FindCommandImpl implements Command {
    private FindCommandReceiver findCommandReceiver;
    private FindCommandCheckImpl findCommandCheck;
    private String args[];

    public FindCommandImpl() {
        this.findCommandReceiver = new FindCommandReceiver();
        this.findCommandCheck = new FindCommandCheckImpl();
    }

    public void execute( Map<String,String> map, String args[]) {
        findCommandCheck.check(map, args) ;
         //   findCommandReceiver.find(parseArguments);
    }

}
