package org.services;

import org.date.Data;

import java.util.Map;

public interface Command{
    public void execute(Data data) throws RuntimeException;
}
