package org.services.list;

import org.parsing.ParseArguments;
import org.services.Command;

/**
 * Created by Юлия on 16.06.2017.
 */
public class ListCommandImpl implements Command{
    private ListCommandReceiver listCommandReceiver;
    private ListCommandCheckImpl listCommandCheck;
    private ParseArguments parseArguments;
    String args[];

    public ListCommandImpl(){
        this.listCommandReceiver = new ListCommandReceiver();
        this.listCommandCheck = new ListCommandCheckImpl();
    }

    public void execute() {
        if(listCommandCheck.check(args) != null) listCommandReceiver.list(parseArguments);
    }
}
