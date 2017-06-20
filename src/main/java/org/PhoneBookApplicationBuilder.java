package org;

import org.services.Command;
import org.services.CommandDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 19.06.2017.
 */
public class PhoneBookApplicationBuilder {
    private List<CommandDefinition> commandDefinition =  new ArrayList<CommandDefinition>();;
    private Map<String,String> params;

    public void setCommandDefinition(CommandDefinition commandDefinition) {
        this.commandDefinition.add(commandDefinition);
    }

    public void  setParams(Map<String, String> params) {
        this.params = params;
    }

    public PhoneBookApplication build(){
        return new PhoneBookApplication(commandDefinition,params);
    }

    public PhoneBookApplicationBuilder withCommands(CommandDefinition commandDefinition){
        setCommandDefinition(commandDefinition);
        return this;
    }

    public PhoneBookApplicationBuilder withConfig(Map<String,String> params){
        setParams(params);
        return this;
    }
}
