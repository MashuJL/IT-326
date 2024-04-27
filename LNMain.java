import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LNMain 
{
    private static LNUserController userController = new LNUserController();
    private LNAccountController acctController = new LNAccountController();
    private LNFolderController folderController = new LNFolderController();
    private LNFileController fileController = new LNFileController();
    private LNNotificationController notifController = new LNNotificationController();
    private LNCommentController commentController = new LNCommentController();
    private static OperationsFactory opFactory = new OperationsFactory();

    public static void main(String[] args) throws FileNotFoundException
    {
        //App UI starts here
        boolean endAllFlag = false;
        Scanner scanner = new Scanner(System.in);
        int userInput;
        boolean loginUser = false;
        boolean noPrint = false;
        while(!endAllFlag)
        {
            if(noPrint == false)
            {
                System.out.println("Select an option: ");
                System.out.println("0: Exit");
                System.out.println("1: Create an account (Not implemented here but will be later)");
                System.out.println("2: Login");
            }
            else
            {
                noPrint = false;
            }
            try
            {
                if(scanner.hasNextLine())
                {
                    userInput = Integer.parseInt(scanner.nextLine());
                    if(userInput < 0 || userInput > 2) 
                    {
                        System.out.println("Error: Please enter a valid option");
                    }
                    else if(userInput == 0) 
                    {
                        System.out.println("Goodbye");
                        endAllFlag = true;
                    }
                    else if(userInput == 1)
                    {

                    }
                    else if(userInput == 2)
                    {
                        System.out.println("Enter a username (must be at most 16 characters and consist of only lowercase letters, uppercase letters, and numbers): ");
                        String username = scanner.nextLine();
                        System.out.println("Enter a password (must be between 8 and 50 characters and must consist of only lowercase letters, uppercase letters, numbers, and the following special characters: @#$%^&+=: ");
                        String password = scanner.nextLine();
                        if(opFactory.getAcctOps().retrieveAcct(username, password) != null)
                        {
                            loginUser = true;
                        }
                        else
                        {
                            System.out.println("Error: Incorrect username or password");
                        }
                    }
                }
                else
                {
                    noPrint = true;
                }
            }
            catch(NumberFormatException e) {
                System.out.println("Error: Please enter a number");
            }

            if(loginUser != false)
            {
            //Login processes ends here (GroceryListMaker code referenced)

                //Loggout process starts here
                boolean endFlag = false;
                while(!endFlag)
                {
                    System.out.println("All account options will be implemented later but rn just loggout");
                    System.out.println("0: Loggout");
                    System.out.println("1: Delete Account");
                    System.out.println("2: Update Account");
                    try
                    {
                        userInput = Integer.parseInt(scanner.nextLine());
                        if(userInput < 0 || userInput > 2) 
                        {
                            System.out.println("Error: Please enter a valid option");
                        }
                        else if(userInput == 0) 
                        {
                            System.out.println("Goodbye");
                            loginUser = false;
                            endFlag = true;
                        }
                        // else if(userInput == 1)
                        // {
                        //     for(int i = 0; i < people.size(); i++)
                        //     {
                        //         if(people.get(i).getEmail().toLowerCase().equals(loginUser.getEmail().toLowerCase()) && people.get(i).getPassword().equals(loginUser.getPassword()))
                        //         {
                        //             String yesOrNo = "";
                        //             while(!yesOrNo.toLowerCase().equals("Yes".toLowerCase()) && !yesOrNo.toLowerCase().equals("No".toLowerCase()))
                        //             {
                        //                 System.out.println("Are you sure you want to do this? (Input Yes or No)");
                        //                 yesOrNo = scanner.nextLine();
                        //                 if(yesOrNo.toLowerCase().equals("Yes".toLowerCase()))
                        //                 {
                        //                     people.remove(i);
                        //                     driver.createWriteAccount(people);
                        //                     readArr = driver.readAccount();
                        //                     loginUser = null;
                        //                     endFlag = true;
                        //                     System.out.println("User deleted successfully");
                        //                 }
                        //                 else if(yesOrNo.toLowerCase().equals("No".toLowerCase()))
                        //                 {
                        //                     System.out.println("User will not be deleted");
                        //                 }
                        //                 else
                        //                 {
                        //                     System.out.println("Please input either yes or no");
                        //                 }
                        //             }
                        //         }
                        //     }
                        // }
                        // else if(userInput == 2)
                        // {
                        //     for(int i = 0; i < people.size(); i++)
                        //     {
                        //         if(people.get(i).getEmail().toLowerCase().equals(loginUser.getEmail().toLowerCase()) && people.get(i).getPassword().equals(loginUser.getPassword()))
                        //         {
                        //             System.out.println("Change username here:");
                        //             String changeUsername = scanner.nextLine();
                        //             System.out.println("Change password here:");
                        //             String changePassword = scanner.nextLine();
                        //             UseCases changeAcct = new UseCases(changeUsername, changePassword);
                        //             people.set(i, changeAcct);
                        //             driver.createWriteAccount(people);
                        //             readArr = driver.readAccount();
                        //             System.out.println("User updated their account successfully!");

                        //         }
                        //     }
                        // }
                    }
                    catch(NumberFormatException e) {
                        System.out.println("Error: Please enter a number");
                    }
                }
                //Loggout process starts here
            }
        }
        scanner.close();
    }
}
