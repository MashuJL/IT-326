import java.io.FileNotFoundException;
import java.io.IOException;
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

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        //App UI starts here
        boolean endAllFlag = false;
        Scanner scanner = new Scanner(System.in);
        int userInput;
        boolean loginUser = false;
        String mainUsername = "";
        String mainPassword = "";
        System.out.println("What would you like your User ID number to be?");
            //TODO: 
            //Change the below line so string input doesn't nuke the system
        int userID = Integer.parseInt(scanner.nextLine());
        opFactory.getUserOps().saveUser(userID, new ArrayList<>());
        while(!endAllFlag)
        {
            System.out.println("Select an option: ");
            System.out.println("0: Exit");
            System.out.println("1: Create an account");
            System.out.println("2: Login");
            System.out.println("3: Block User");
            System.out.println("4: Unblock user");
            System.out.println("5: Pin comment");
            System.out.println("6: Remove comment");
            System.out.println("7: Edit comment");
            try
            {
                if(scanner.hasNextLine())
                {
                    userInput = Integer.parseInt(scanner.nextLine());
                    if(userInput < 0 || userInput > 7) 
                    {
                        System.out.println("Error: Please enter a valid option\n");
                    }
                    else if(userInput == 0) 
                    {
                        System.out.println("Goodbye");
                        endAllFlag = true;
                    }
                    else if(userInput == 1)
                    {
                        System.out.println("Enter a username (must be at most 16 characters and consist of only lowercase letters, uppercase letters, and numbers): ");
                        String username = scanner.nextLine();
                        System.out.println("Enter a password (must be between 8 and 50 characters and must consist of only lowercase letters, uppercase letters, numbers, and the following special characters: @#$%^&+=: ");
                        String password = scanner.nextLine();
                        // LNAccount jackson = new LNAccount("jwclar1@ilstu.edu", "M@rth1009");
                        // LNAccount warren = new LNAccount("whern2@mistu.edu", "Dogar120");
                        // LNAccount newAcct = new LNAccount(username, password);
                        // ArrayList<LNAccount> accts = new ArrayList<>();
                        // accts.add(newAcct);
                        // accts.add(jackson);
                        // accts.add(warren);
                        if(opFactory.getAcctOps().saveAcct(userID, userController.createAccount(username, password, opFactory.getUserOps().retrieveUser(userID))) != false)
                        {
                            System.out.println("Account was created and saved successfully!");
                        }
                        else
                        {
                            System.out.println("Error: Account not created");
                        }
                    }
                    else if(userInput == 2)
                    {
                        //TODO:
                        //Add regexes to enforce password restrictions
                        System.out.println("Enter a username (must be at most 16 characters and consist of only lowercase letters, uppercase letters, and numbers): ");
                        String username = scanner.nextLine();
                        System.out.println("Enter a password (must be between 8 and 50 characters and must consist of only lowercase letters, uppercase letters, numbers, and the following special characters: @#$%^&+=: ");
                        String password = scanner.nextLine();
                        if(opFactory.getAcctOps().retrieveAcct(username, password) != null)
                        {
                            mainUsername = username;
                            mainPassword = password;
                            loginUser = true;
                        }
                        else
                        {
                            System.out.println("Error: Incorrect username or password");
                        }
                    }
                    else if(userInput == 3) //Block User
                    {
                        if(!loginUser)
                        {
                            System.out.println("Must be logged in to block user.");
                        }
                        //LNAccount loggedIn = opFactory.getAcctOps().retrieveAcct(mainUsername, mainPassword);
                        else
                        {
                            System.out.println("Im blocking sucessfully now");
                        }
                    }
                    else if(userInput == 4) //Unblock User
                    {

                    }
                    else if(userInput == 5) //Pin Comment
                    {

                    }
                    else if(userInput == 6) //Remove Comment
                    {

                    }
                    else if(userInput == 7) //Edit Comment
                    {

                    }
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
                        else if(userInput == 1)
                        {
                            String yesOrNo = "";
                            while(!yesOrNo.toLowerCase().equals("Yes".toLowerCase()) && !yesOrNo.toLowerCase().equals("No".toLowerCase()))
                            {
                                System.out.println("Are you sure you want to do this? (Input Yes or No)");
                                yesOrNo = scanner.nextLine();
                                if(yesOrNo.toLowerCase().equals("Yes".toLowerCase()))
                                {
                                    boolean delete = opFactory.getAcctOps().deleteAccount(mainUsername, mainPassword, opFactory.getUserOps().retrieveUser(userID));
                                    opFactory.getUserOps().saveUser(userID, opFactory.getUserOps().retrieveUser(userID).getAccounts());
                                    if(delete == true)
                                    {
                                        mainUsername = "";
                                        mainPassword = "";
                                        loginUser = false;
                                        endFlag = true;
                                        System.out.println("Account successfully deleted");
                                    }
                                    else
                                    {
                                        System.out.println("Error: Account not deleted");
                                    }
                                }
                                else if(yesOrNo.toLowerCase().equals("No".toLowerCase()))
                                {
                                    System.out.println("User will not be deleted");
                                }
                                else
                                {
                                    System.out.println("Please input either yes or no");
                                }
                            }
                        }
                        else if(userInput == 2)
                        {
                            System.out.println("Change username here:");
                            String changeUsername = scanner.nextLine();
                            System.out.println("Change password here:");
                            String changePassword = scanner.nextLine();
                            boolean update = opFactory.getAcctOps().updateAccount(changeUsername, changePassword, mainUsername, mainPassword, opFactory.getUserOps().retrieveUser(userID));
                            opFactory.getUserOps().saveUser(userID, opFactory.getUserOps().retrieveUser(userID).getAccounts());
                            if(update == true)
                            {
                                mainUsername = changeUsername;
                                mainPassword = changePassword;
                                System.out.println("Account successfully updated!");
                            }
                            else
                            {
                                System.out.println("Error: Account not updated");
                            }
                        }
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
