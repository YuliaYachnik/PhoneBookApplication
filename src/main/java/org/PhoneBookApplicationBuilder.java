package org;

import org.date.SetGetObject;
import org.services.CommandDefinition;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneBookApplicationBuilder {
    private List<CommandDefinition> commandDefinition =  new ArrayList<CommandDefinition>();
    private Map<String,String> params;
    private SetGetObject objectClass;



    public PhoneBookApplication build(){
        return new PhoneBookApplication(commandDefinition,params,objectClass);
    }

    public PhoneBookApplicationBuilder withCommands(CommandDefinition commandDefinition){
        this.commandDefinition.add(commandDefinition);
        return this;
    }
    public PhoneBookApplicationBuilder withConfig(Map<String,String> params){
        this.params = params;
        return this;
    }

    public PhoneBookApplicationBuilder forData(SetGetObject objectClass){
        this.objectClass = objectClass;
        return this;
    }
}
