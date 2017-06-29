package org.services.list;

import org.date.PhoneBookData;
import org.junit.Test;

import java.io.IOException;

public class ListCommandImplTest {
    PhoneBookData phoneBookData = new PhoneBookData("Nick","234135","NickPhone.txt","Phone");
    ListCommandImpl listCommand = new ListCommandImpl();

    /*@Test
    public void checkLReadFromFile() throws IOException{
        listCommand.execute(phoneBookData);
    }
*/
}