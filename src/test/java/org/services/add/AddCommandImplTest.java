package org.services.add;

import org.date.PhoneBookData;
import org.junit.Test;

import java.io.IOException;

public class AddCommandImplTest {

    AddCommandImpl addCommand = new AddCommandImpl();
    PhoneBookData phoneBookData = new PhoneBookData("Nick","234135","NickPhone.txt","Phone");

   /* @Test
    public void checkWriteInFile()throws IOException{
        addCommand.execute(phoneBookData);
    }*/
}