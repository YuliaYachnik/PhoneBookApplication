package org.services.find;

        import org.date.PhoneBookData;
        import org.junit.Test;

        import java.io.IOException;

public class FindCommandImplTest {
    PhoneBookData phoneBookData = new PhoneBookData("Nick","234135","NickPhone.txt","Phone");
    FindCommandImpl findCommand = new FindCommandImpl();
/*
    @Test
    public void checkFindInFile() throws IOException {
        findCommand.execute(phoneBookData);
    }*/
}