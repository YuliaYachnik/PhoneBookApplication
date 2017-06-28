package org.services.add;

import org.date.Data;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AddCommandImplTest {

    AddCommandImpl addCommand = new AddCommandImpl();
    Data data = new Data("Nick","234135","NickPhone.txt","Phone");

    @Test
    public void checkWriteInFile()throws IOException{
        addCommand.execute(data);
    }
}