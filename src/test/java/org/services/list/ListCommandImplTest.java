package org.services.list;

import org.date.Data;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListCommandImplTest {
    Data data = new Data("Nick","234135","NickPhone.txt","Phone");
    ListCommandImpl listCommand = new ListCommandImpl();

    @Test
    public void checkLReadFromFile(){
        listCommand.execute(data);
    }

}