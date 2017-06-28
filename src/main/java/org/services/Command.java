package org.services;

import org.date.Data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface Command{
    void execute(Data data) throws IOException;
}
