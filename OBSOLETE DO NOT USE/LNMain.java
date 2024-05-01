import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class LNMain 
{
    //private static LNUserController userController = new LNUserController();
    private static LNAccountController acctController = new LNAccountController();
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
        String loginUsername = "";
        String loginPassword = "";
        Random rand = new Random();
        int userID = rand.nextInt(1000);
        opFactory.getUserOps().saveUser(userID, new ArrayList<>());
        while(!endAllFlag)
        {
            System.out.println("Select an option: ");
            System.out.println("0: Exit");
            System.out.println("1: Create an account");
            System.out.println("2: Login");
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
                    else if(userInput == 1) //Create Account
                    {
                        //System.out.println("Enter a username (must be at most 16 characters and consist of only lowercase letters, uppercase letters, and numbers): ");
                        System.out.println("Enter a email");
                        String username = scanner.nextLine();
                        //System.out.println("Enter a password (must be between 8 and 50 characters and must consist of only lowercase letters, uppercase letters, numbers, and the following special characters: @#$%^&+=: ");
                        System.out.println("Enter a password");
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
                        //System.out.println("Enter a username (must be at most 16 characters and consist of only lowercase letters, uppercase letters, and numbers): ");
                        System.out.println("Enter a email");
                        String username = scanner.nextLine();
                        //System.out.println("Enter a password (must be between 8 and 50 characters and must consist of only lowercase letters, uppercase letters, numbers, and the following special characters: @#$%^&+=: ");
                        System.out.println("Enter a password");
                        String password = scanner.nextLine();
                        if(userController.login(username, password, opFactory.getUserOps().retrieveUser(userID)) == true)
                        {
                            loginUsername = username;
                            loginPassword = password;
                            loginUser = true;
                        }
                        else
                        {
                            System.out.println("Error: Incorrect username or password");
                        }
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
                    //TODO: Remove this first statement in final program
                    System.out.println("\nAll account options will be implemented later but rn just loggout");
                    System.out.println("0: Log Out");
                    System.out.println("1: Delete Account");
                    System.out.println("2: Update Account");
                    System.out.println("3: Block User");
                    System.out.println("4: Unblock user");
                    System.out.println("5: Pin comment");
                    System.out.println("6: Remove comment");
                    System.out.println("7: Edit comment");
                    try
                    {
                        userInput = Integer.parseInt(scanner.nextLine());
                        if(userInput < 0 || userInput > 7) 
                        {
                            System.out.println("Error: Please enter a valid option");
                        }
                        else if(userInput == 0) 
                        {
                            if(acctController.loggout() == true)
                            {
                                loginUsername = "";
                                loginPassword = "";
                                loginUser = false;
                                endFlag = true;
                            }
                        }
                        else if(userInput == 1) //Log Out
                        {
                            String yesOrNo = "";
                            while(!yesOrNo.toLowerCase().equals("Yes".toLowerCase()) && !yesOrNo.toLowerCase().equals("No".toLowerCase()))
                            {
                                System.out.println("Are you sure you want to do this? (Input Yes or No)");
                                yesOrNo = scanner.nextLine();
                                if(yesOrNo.toLowerCase().equals("Yes".toLowerCase()))
                                {
                                    opFactory.getUserOps().saveUser(userID, opFactory.getAcctOps().deleteAccount(loginUsername, loginPassword, opFactory.getUserOps().retrieveUser(userID)));
                                    // if(delete == true)
                                    // {
                                        loginUsername = "";
                                        loginPassword = "";
                                        loginUser = false;
                                        endFlag = true;
                                        // System.out.println("Account successfully deleted");
                                    // }
                                    // else
                                    // {
                                    //     System.out.println("Error: Account not deleted");
                                    // }
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
                        else if(userInput == 2) //Update Account
                        {
                            System.out.println("Change email here:");
                            String changeUsername = scanner.nextLine();
                            System.out.println("Change password here:");
                            String changePassword = scanner.nextLine();
                            opFactory.getUserOps().saveUser(userID, opFactory.getAcctOps().updateAccount(changeUsername, changePassword, loginUsername, loginPassword, opFactory.getUserOps().retrieveUser(userID)));
                            loginUsername = changeUsername;
                            loginPassword = changePassword;
                            System.out.println("Account successfully updated!");
                        }
                        else if(userInput == 3) //Block User
                        {
                            //TODO: Test
                            System.out.println("CURRENT USER NAME: "+loginUsername+"\nCURRENT USER PASS: "+loginPassword);
                            //TODO: End test
                            System.out.print("Enter the ID of the user you want to block: ");
                            //TODO: Check for bad input here
                            int blockID = Integer.parseInt(scanner.nextLine()); //Temp User ID we attempt to block
                            LNAccountController lnac = new LNAccountController();
                            lnac.blockUser(loginUsername, loginPassword, userID, blockID);
                            //TODO: Test
                            LNAccount tact = opFactory.getAcctOps().retrieveAcct(loginUsername, loginPassword);
                            System.out.println("Size of blocked = "+tact.getBlockedUsers().size());
                            //TODO: End test
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
