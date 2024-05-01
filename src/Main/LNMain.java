package Main;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Controllers.LNAccountController;
import Handlers.LNAccountHandler;

public class LNMain 
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        boolean endAllFlag = false; //End the app boolean variable
        Scanner scanner = new Scanner(System.in); //Gets user input
        int userInput; //Stores user input
        boolean loginUser = false; //End the user experience boolean variable
        String loginUsername = ""; //Stores the current logged in user's email
        String loginPassword = ""; //Stores the current logged in user's password
        //App starts here
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
                        System.out.println("Enter a email");
                        String username = scanner.nextLine();
                        System.out.println("Enter a password");
                        String password = scanner.nextLine();
                        if(LNAccountController.createAccount(username, password))
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
                        System.out.println("Enter a email");
                        String username = scanner.nextLine();
                        System.out.println("Enter a password");
                        String password = scanner.nextLine();
                        if(LNAccountController.login(username, password))
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
            catch(NumberFormatException e) { //Catching user inputting anything but a number
                System.out.println("Error: Please enter a number");
            }

            if(loginUser != false)
            {
                //User experience starts here
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
                            if(LNAccountController.loggout())
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
                                    if(LNAccountController.deleteAccount(loginUsername, loginPassword))
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
                            if(LNAccountController.updateAccount(changeUsername, changePassword, loginUsername, loginPassword))
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
                //User experience ends here
            }
        }
        //App ends here
        PrintWriter pw = new PrintWriter("accounts.csv");
        pw.print(""); //Clears file after use
        pw.close();
        scanner.close();
    }
}
