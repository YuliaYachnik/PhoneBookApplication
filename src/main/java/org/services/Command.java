package org.services;

import org.date.PhoneBookData;
import org.date.PrintObject;

import java.io.IOException;

public interface Command{
    void execute(Class <PrintObject> objectClass) throws IOException;
}
