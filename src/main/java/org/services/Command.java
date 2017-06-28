package org.services;

import org.date.Data;
import java.io.IOException;

public interface Command{
    void execute(Data data) throws IOException;
}
