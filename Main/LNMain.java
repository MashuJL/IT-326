package Main;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Controllers.LNAccountController;
import Handlers.LNAccountHandler;

public class LNMain 
{
    public static LNAccountHandler getAcctHandler()
    {
        return LNAccountController.getLNAccountHandlerInstance();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        //App UI starts here
        boolean endAllFlag = false;
        Scanner scanner = new Scanner(System.in);
        int userInput;
        boolean loginUser = false;
        String loginUsername = "";
        String loginPassword = "";
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
                        
                        //System.out.println("Enter a username (must be at most 16 characters and consist of only lowercase letters, uppercase letters, and numbers): ");
                        System.out.println("Enter a email");
                        String username = scanner.nextLine();
                        //System.out.println("Enter a password (must be between 8 and 50 characters and must consist of only lowercase letters, uppercase letters, numbers, and the following special characters: @#$%^&+=: ");
                        System.out.println("Enter a password");
                        String password = scanner.nextLine();
                        if(getAcctHandler().createAccount(username, password))
                        {
                            System.out.println("Account was created and saved successfully!");
                        }
                        else
                        {
                            System.out.println(" Account not created.");
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
                        if(getAcctHandler().login(username, password))
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
            //Login processes ends here

                //Loggout/Delete process starts here
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
                            if(getAcctHandler().loggout())
                            {
                                loginUsername = "";
                                loginPassword = "";
                                loginUser = false;
                                endFlag = true;
                            }
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
                                    if(getAcctHandler().getAcctOps().deleteAccount(loginUsername, loginPassword))
                                    {
                                        loginUsername = "";
                                        loginPassword = "";
                                        loginUser = false;
                                        endFlag = true;
                                    }
                                    else
                                    {
                                        System.out.println("User was not deleted");
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
                            System.out.println("Change email here:");
                            String changeUsername = scanner.nextLine();
                            System.out.println("Change password here:");
                            String changePassword = scanner.nextLine();
                            if(getAcctHandler().getAcctOps().updateAccount(changeUsername, changePassword, loginUsername, loginPassword))
                            {
                                loginUsername = changeUsername;
                                loginPassword = changePassword;
                                System.out.println("Account successfully updated!");
                            }
                            else
                            {
                                System.out.println("User was not updated");
                            }
                        }
                    }
                    catch(NumberFormatException e) {
                        System.out.println("Error: Please enter a number");
                    }
                }
                //Loggout/Delete process starts here
            }
        }
        PrintWriter pw = new PrintWriter("accounts.csv");
        pw.print(""); //Clears file after use
        pw.close();
        scanner.close();
    }
}
