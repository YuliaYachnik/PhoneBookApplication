package org.services.list;

import org.services.Check;
import org.services.ParametrDefinitions;

import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 21.06.2017.
 */
public class ListCommandCheckImpl implements Check {
   private CheckListCommandReceiver checkListCommandReceiver;

    public ListCommandCheckImpl() {
        this.checkListCommandReceiver = new CheckListCommandReceiver();
    }

    @Override
    public boolean check( List<ParametrDefinitions> parametrDefinitions, String args[]) {
        checkListCommandReceiver.checkListCommand();
        return true;
    }
}
