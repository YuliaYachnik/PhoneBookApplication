package org.services.checker;

/**
 * Created by Юлия on 21.06.2017.
 */
public class HelpCommandCheckImpl implements Check {
    @Override
    public Check check(String args[]) {
        System.out.println("I'm HelpCommand check!");
        return this;

    }
}
