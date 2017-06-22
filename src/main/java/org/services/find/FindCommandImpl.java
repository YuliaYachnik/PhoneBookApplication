package org.services.find;

import org.services.CheckManager;
import org.services.Command;
import org.services.ParametrDefinitions;
import org.services.find.checkFind.FindCommandCheckImpl;

import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 16.06.2017.
 */
public class FindCommandImpl implements Command {
    private FindCommandReceiver findCommandReceiver;
    private FindCommandCheckImpl findCommandCheck;

    public FindCommandImpl() {
        this.findCommandReceiver = new FindCommandReceiver();
        this.findCommandCheck = new FindCommandCheckImpl();
    }

    public void execute(CheckManager checkManager) {
         // findCommandReceiver.find(findCommandCheck.check(map, args));
    }

}
