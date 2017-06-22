package org.services.add.checkAdd;

import org.services.Check;
import org.services.ParametrDefinitions;

import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 20.06.2017.
 */
public class AddCommandCheckImpl implements Check {
    private CheckAddCommandReceiver checkAddCommandReceiver;

    public AddCommandCheckImpl() {
        this.checkAddCommandReceiver = new CheckAddCommandReceiver();
    }

    @Override
    public String[] check( Map<String,String> map, String args[]) {
        try{
        String str[]  = checkAddCommandReceiver.checkAddCommand(map,args);
        if(str != null) return str;
        else throw new RuntimeException();
        }catch (RuntimeException e){
            System.out.println("Command Add is not valid! Please, use help-manager");
            return null;
        }
    }
}
