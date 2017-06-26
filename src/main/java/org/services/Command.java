package org.services;

import org.date.Data;

import java.io.FileNotFoundException;
import java.util.Map;

public interface Command{
    public void execute(Data data) throws RuntimeException, FileNotFoundException;
}
