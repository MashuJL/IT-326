package JUnitTests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Handlers.LNAccountHandler;

public class LoginTest{
    private LNAccountHandler acctHandler;
    private File csvFile;

    @Before
    public void setUp() throws FileNotFoundException{
        acctHandler = new LNAccountHandler();
        csvFile = new File("accounts.csv");
    }

    /*
     * Basis Path Testing - Part 1 (24->26->27->35)
     */
    @Test
    public void testingNoAccountFoundInAccountsCSV() throws IOException, ClassNotFoundException{
        String username = "jwclar1@ilstu.edu";
        String password = "j@ckson149";
        acctHandler.createAccount("jacksonclarkit@gmail.com", password);
        boolean expected = false;
        boolean actual = acctHandler.login(username, password);
        assertEquals(expected, actual);
    }

    /*
     * Basis Path Testing - Part 2 (24->26->27->29->35)
     */
    @Test
    public void testingPasswordDoesntMatchAccount() throws IOException, ClassNotFoundException{
        String username = "jwclar1@ilstu.edu";
        String password = "j@ckson149";
        acctHandler.createAccount(username, "j@ckson139");
        boolean expected = false;
        boolean actual = acctHandler.login(username, password);
        assertEquals(expected, actual);
    }

    /*
     * Basis Path Testing - Part 2 (24->26->27->29->31)
     */
    @Test
    public void testingUsernameAndPasswordMatch() throws IOException, ClassNotFoundException{
        String username = "jwclar1@ilstu.edu";
        String password = "j@ckson149";
        acctHandler.createAccount(username, password);
        boolean expected = true;
        boolean actual = acctHandler.login(username, password);
        assertEquals(expected, actual);
    }

    @After
    public void cleanUp(){
        acctHandler = null;
        csvFile.delete();
    }

}
