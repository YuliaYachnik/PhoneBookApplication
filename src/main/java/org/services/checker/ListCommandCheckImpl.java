package org.services.checker;

/**
 * Created by Юлия on 21.06.2017.
 */
public class ListCommandCheckImpl implements Check {
    @Override
    public Check check(String args[]) {
        System.out.println("I'm listCommandCheck!");
        return this;
    }
}
