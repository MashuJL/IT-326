import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

class User 
{
    private int userID;

    public User (int userID)
    {
        this.userID = userID;
    }

    public int getID()
    {
        return userID;
    }

    public boolean Login(String email, String pw)
    {
        int count = 0;
        boolean emailCheck = false;
        boolean pwCheck = false;
        try(BufferedReader read = new BufferedReader(new FileReader("UserTest.txt"))) {
            String line;
            while((line = read.readLine()) != null)
            {
                count++;
                if(count % 2 == 1)
                {
                    if(line.equals(email))
                    {
                        emailCheck = true;
                    }
                }
                else
                {
                    if(line.equals(pw))
                    {
                        pwCheck = true;
                        if(emailCheck == true && pwCheck == true)
                        {
                            return true;
                        }
                        else
                        {
                            emailCheck = false;
                            pwCheck = false;
                        }
                    }
                }
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return false;
    }
}

class Test
{
    public static void main(String args[])
    {
        Random rand = new Random();
        int randID = rand.nextInt(1000);
        User user = new User(randID);
        System.out.println("User ID: " + user.getID());
        System.out.println("Testing login (should output true): " + user.Login("jclark@gmail.com", "Password123"));
    }
}