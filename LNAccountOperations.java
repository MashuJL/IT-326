import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LNAccountOperations extends LNAccountCRUDOps
{
    public LNAccount retrieveAcct(String username, String password) throws FileNotFoundException
    {
        File file = new File("people.csv");
        Scanner scan = new Scanner(file);
        ArrayList<String> strArr = new ArrayList<>();
            while (scan.hasNextLine())
            {
                String[] readArr = scan.nextLine().split(" ");
                for(int i = 0; i < readArr.length; i++)
                {
                    strArr.add(readArr[i]);
                }
            }
            scan.close();
            for(int i = 0; i < strArr.size(); i+=2)
            {
                if(strArr.get(i).toLowerCase().equals(username.toLowerCase()) && strArr.get(i+1).equals(password))
                {
                    scan.close();
                    return new LNAccount(username, password);
                }
            }
        
        System.out.println("Error: No accounts made");
        scan.close();
        return null;
    }
}
