package org.services.list;

import org.services.Check;

/**
 * Created by Юлия on 21.06.2017.
 */
public class ListCommandCheckImpl implements Check {
   private CheckListCommandReceiver checkListCommandReceiver;

    public ListCommandCheckImpl() {
        this.checkListCommandReceiver = new CheckListCommandReceiver();
    }

    @Override
    public Check check(String args[]) {
        checkListCommandReceiver.checkListCommand();
        return this;
    }
}
