package org.services.checker;

/**
 * Created by Юлия on 20.06.2017.
 */
public class AddCommandCheckImpl implements Check {
    private  CheckAddCommandReceiver checkAddCommandReceiver;

    public AddCommandCheckImpl() {
        this.checkAddCommandReceiver = new CheckAddCommandReceiver();
    }

    @Override
    public Check check(String args[]) {
        checkAddCommandReceiver.checkAddCommand();
        return this;
    }
}
