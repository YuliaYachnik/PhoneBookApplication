package org.services.find;

import org.date.Data;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class FindCommandImplTest {
    Data data = new Data("Nick","234135","NickPhone.txt","Phone");
    FindCommandImpl findCommand = new FindCommandImpl();

    @Test
    public void checkFindInFile() throws FileNotFoundException {
        findCommand.execute(data);
    }
}