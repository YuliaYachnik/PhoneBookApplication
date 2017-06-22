package org.services;

import java.util.Map;

public interface Command{
    public void execute( Map<String,String>map,String args[]);
}
