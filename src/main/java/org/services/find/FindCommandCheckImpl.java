package org.services.find;

import org.services.Check;

/**
 * Created by Юлия on 21.06.2017.
 */
public class FindCommandCheckImpl implements Check {
    private CheckFindCommandReceiver checkFindCommandReceiver;

    public FindCommandCheckImpl() {
        this.checkFindCommandReceiver = new CheckFindCommandReceiver();
    }

    @Override
    public Check check(String args[]) {
        checkFindCommandReceiver.checkFindCommand();
        return this;

    }
}
