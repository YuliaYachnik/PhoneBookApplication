package org.services;

import org.date.SetGetObject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Command{
    void execute(SetGetObject objectClass) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException;
}
