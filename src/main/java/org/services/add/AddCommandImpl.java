package org.services.add;

import org.parsing.ParseArguments;
import org.services.Command;

/**
 * Created by Юлия on 16.06.2017.
 */
public class AddCommandImpl implements Command{
    private AddCommandReceiver addCommandReceiver;
 //   private  ParseArguments parseArguments;

   // public AddCommandImpl(AddCommandReceiver addCommandReceiver){
      //  this.parseArguments = parseArguments;
      //  this.addCommandReceiver = addCommandReceiver;
  //  }

    public AddCommandImpl(){
        addCommandReceiver = new AddCommandReceiver();
    }

    public void execute() {
         addCommandReceiver.add();

    }
}
