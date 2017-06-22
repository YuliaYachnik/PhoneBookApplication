package org.services.list;

import org.services.Command;
import org.services.CommandDefinition;

import java.util.Map;

/**
 * Created by Юлия on 16.06.2017.
 */
public class ListCommandImpl implements Command{
    private ListCommandReceiver listCommandReceiver;
    private ListCommandCheckImpl listCommandCheck;


    public ListCommandImpl(){
        this.listCommandReceiver = new ListCommandReceiver();
        this.listCommandCheck = new ListCommandCheckImpl();
    }

    public void execute( Map<String,String> map,String args[]) {
        listCommandCheck.check(map,args) ;
            listCommandReceiver.list();
    }
}
