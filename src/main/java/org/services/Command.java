package org.services;

import org.date.DataObjectWorking;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Command{
    void execute(DataObjectWorking objectClass) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException;
}
