package org.services.find;

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
    public String[] check( Map<String,String> map, String args[]) {
        checkFindCommandReceiver.checkFindCommand();
        return args;

    }
}
