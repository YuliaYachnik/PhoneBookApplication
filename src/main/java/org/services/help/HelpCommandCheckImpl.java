package org.services.help;

import org.services.Check;

/**
 * Created by Юлия on 21.06.2017.
 */
public class HelpCommandCheckImpl implements Check {
    private CheckHelpCommandReceiver checkHelpCommandReceiver;

    public HelpCommandCheckImpl() {
        this.checkHelpCommandReceiver = new CheckHelpCommandReceiver();
    }

    @Override
    public Check check(String args[]) {
        this.checkHelpCommandReceiver.checkHelpCommand();
        return this;

    }
}
