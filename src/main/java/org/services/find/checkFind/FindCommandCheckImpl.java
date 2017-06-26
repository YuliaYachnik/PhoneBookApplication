package org.services.find.checkFind;

import org.services.Check;
import org.services.ParametrDefinitions;

import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 21.06.2017.
 */
public class FindCommandCheckImpl implements Check {
    private CheckFindCommandReceiver checkFindCommandReceiver;

    public FindCommandCheckImpl() {
        this.checkFindCommandReceiver = new CheckFindCommandReceiver();
    }

    @Override
    public boolean check(List<ParametrDefinitions> parametrDefinitions,Map<String,String> optionalParams, String args[]) {
        /*try{
            String str[]  = checkFindCommandReceiver.checkFindCommand(map,args);
            if(str != null) return str;
            else throw new RuntimeException();
        }catch (RuntimeException e){
            System.out.println("Command Find is not valid! Please, use help-manager");
            return null;
        }*/
        return true;
    }
}
