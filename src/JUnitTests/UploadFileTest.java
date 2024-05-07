package JUnitTests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Handlers.LNFileHandler;

public class UploadFileTest {
    LNFileHandler testHandle;
    File csvFile;
    
    @Before
    public void setUp() throws FileNotFoundException{
        testHandle = new LNFileHandler();
        csvFile = new File("files.csv");
    }
    @Test
    public void testVerificationInName() throws ClassNotFoundException, IOException{
        String name = null;
        int folder = 0;
        String account = "paul";
        boolean expected = false;
        boolean result = testHandle.uploadFile(name, folder, account);
        assertEquals(expected, result);
    }
    @Test
    public void testVerificationInAccount() throws ClassNotFoundException, IOException{
        String name = "bills";
        int folder = 0;
        String account = null;
        boolean expected = false;
        boolean result = testHandle.uploadFile(name, folder, account);
        assertEquals(expected, result);
    }
    @Test
    public void testVerificationOneFile() throws ClassNotFoundException, IOException{
        String name = "bills";
        int folder = 0;
        String account = "paul";
        boolean expected = true;
        boolean result = testHandle.uploadFile(name, folder, account);
        assertEquals(expected, result);
    }
    @Test
    public void testFolderDifference() throws ClassNotFoundException, IOException{
        String name = "berries";
        int folder1 = 0;
        int folder2 = 1;
        String account = "Sam";
        boolean expected = true;
        testHandle.uploadFile(name,folder1,account);
        boolean result = testHandle.uploadFile(name, folder2, account);
        assertEquals(expected, result);
    }
    @Test
    public void testAccountDifference() throws ClassNotFoundException, IOException{
        String name = "groceries";
        int folder = 0;
        String account1 = "John";
        String account2 = "Paul";
        boolean expected = true;
        testHandle.uploadFile(name,folder,account1);
        boolean result = testHandle.uploadFile(name, folder, account2);
        assertEquals(expected, result);
    }
    @Test
    public void testNameDifference() throws ClassNotFoundException, IOException{
        String name1 = "fish";
        String name2 = "french";
        int folder = 0;
        String account = "paul";
        boolean expected = true;
        testHandle.uploadFile(name1,folder,account);
        boolean result = testHandle.uploadFile(name2, folder, account);
        assertEquals(expected, result);
    }
    public void testDuplicateFile() throws ClassNotFoundException, IOException{
        String name = "bills";
        int folder = 0;
        String account = "paul";
        boolean expected = false;
        testHandle.uploadFile(name, folder, account);
        boolean result = testHandle.uploadFile(name, folder, account);
        assertEquals(expected, result);
    }
    @After
    public void cleanUp(){
        testHandle = null;
        csvFile.delete(); //Clears the file after use
    }
}
