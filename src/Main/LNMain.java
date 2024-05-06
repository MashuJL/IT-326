package Main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Controllers.LNAccountController;
import Controllers.LNCommentController;
import Controllers.LNFileController;
import Models.LNAccount;

public class LNMain
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        boolean endAllFlag = false; // End the app boolean variable
        Scanner scanner = new Scanner(System.in); // Gets user input
        int userInput; // Stores user input
        boolean loginUser = false; // End the user experience boolean variable
        String loginUsername = ""; // Stores the current logged in user's email
        String loginPassword = ""; // Stores the current logged in user's password
        // App starts here
        while (!endAllFlag)
        {
            System.out.println("Select an option: ");
            System.out.println("0: Exit");
            System.out.println("1: Create an account");
            System.out.println("2: Login");
            try
            {
                if (scanner.hasNextLine())
                {
                    userInput = Integer.parseInt(scanner.nextLine());
                    if (userInput < 0 || userInput > 2)
                    {
                        System.out.println("Error: Please enter a valid option");
                    }
                    else if (userInput == 0)
                    {
                        System.out.println("Goodbye");
                        endAllFlag = true;
                    }
                    else if (userInput == 1)
                    {
                        System.out.println("Enter a email");
                        String username = scanner.nextLine();
                        System.out.println("Enter a password");
                        String password = scanner.nextLine();
                        if (LNAccountController.createAccount(username, password))
                        {
                            System.out.println("Account was created and saved successfully!");
                        }
                        else
                        {
                            System.out.println(" Account not created.");
                        }
                    }
                    else if (userInput == 2)
                    {
                        System.out.println("Enter a email");
                        String username = scanner.nextLine();
                        System.out.println("Enter a password");
                        String password = scanner.nextLine();
                        if (LNAccountController.login(username, password))
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
            catch (NumberFormatException e)
            { // Catching user inputting anything but a number
                System.out.println("Error: Please enter a number");
            }

            if (loginUser != false)
            {
                // User experience starts here
                boolean endFlag = false;
                while (!endFlag)
                {
                    System.out.println("0: Loggout");
                    System.out.println("1: Delete Account");
                    System.out.println("2: Update Account");
                    System.out.println("3: Block User");
                    System.out.println("4: Unblock User");
                    System.out.println("5: Pin Comment");
                    System.out.println("6: Remove Comment");
                    System.out.println("7: Edit Comment");
                    System.out.println("8: Check notifactions" + "(" + LNAccountController.getNotifCount(loginUsername)
                            + " new notification(s))");
                    System.out.println("9: Clear all notifications");
                    System.out.println("10: Disable Notifiactions");
                    System.out.println("11: view file");
                    System.out.println("12: search for a comment");
                    try
                    {
                        userInput = Integer.parseInt(scanner.nextLine());
                        if (userInput < 0 || userInput > 12)
                        {
                            System.out.println("Error: Please enter a valid option");
                        }
                        else if (userInput == 0)
                        {
                            if (LNAccountController.loggout())
                            {
                                loginUsername = "";
                                loginPassword = "";
                                loginUser = false;
                                endFlag = true;
                            }
                        }
                        else if (userInput == 1)
                        {
                            String yesOrNo = "";
                            while (!yesOrNo.toLowerCase().equals("Yes".toLowerCase())
                                    && !yesOrNo.toLowerCase().equals("No".toLowerCase()))
                            {
                                System.out.println("Are you sure you want to do this? (Input Yes or No)");
                                yesOrNo = scanner.nextLine();
                                if (yesOrNo.toLowerCase().equals("Yes".toLowerCase()))
                                {
                                    if (LNAccountController.deleteAccount(loginUsername, loginPassword))
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
                                else if (yesOrNo.toLowerCase().equals("No".toLowerCase()))
                                {
                                    System.out.println("User will not be deleted");
                                }
                                else
                                {
                                    System.out.println("Please input either yes or no");
                                }
                            }
                        }
                        else if (userInput == 2)
                        {
                            System.out.println("Change email here:");
                            String changeUsername = scanner.nextLine();
                            System.out.println("Change password here:");
                            String changePassword = scanner.nextLine();
                            if (LNAccountController.updateAccount(changeUsername, changePassword, loginUsername,
                                    loginPassword))
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
                        else if (userInput == 3)
                        {
                            System.out.println("All accounts & IDs: ");
                            LNAccountController.printNamesAndIDs();
                            LNAccountController.printBlockedUsers(loginUsername);
                            System.out.println("Enter the ID of the user you want to block: ");
                            try
                            {
                                int blocked = Integer.parseInt(scanner.nextLine());
                                if (LNAccountController.blockUser(loginUsername, blocked))
                                    System.out.println("User ID = " + blocked + " blocked successfully!");
                                else
                                    System.out.println("Failed to block user ID = " + blocked
                                            + " (User is already blocked, ID does not exist or attempted to block own ID)");
                            }
                            catch (NumberFormatException e)
                            {
                                System.err.println("Invalid ID number");
                            }
                        }
                        else if (userInput == 4) // Unblock user
                        {
                            int numBlocked = LNAccountController.printBlockedUsers(loginUsername);
                            if (numBlocked == 0)
                            {
                                System.out.println("You have no currently blocked users.");
                            }
                            else
                            {
                                System.out.println("Enter the ID of the user you want to unblock: ");
                                try
                                {
                                    int unblocked = Integer.parseInt(scanner.nextLine());
                                    if (LNAccountController.unblockUser(loginUsername, unblocked))
                                        System.out.println("User ID = " + unblocked + " unblocked successfully!");
                                    else
                                        System.out.println(
                                                "Failed to unblock user ID = " + unblocked + " (User is not blocked)");
                                }
                                catch (NumberFormatException e)
                                {
                                    System.err.println("Invalid ID number");
                                }
                            }
                        }
                        else if (userInput == 5) // Pin Comment
                        {
                            int numCmts = LNAccountController.printComments(loginUsername);
                            if (numCmts == 0)
                                System.out.println("You have no comments to pin.");
                            else
                            {
                                System.out.println("Enter the number of the comment you want to pin: ");
                                try
                                {
                                    int selected = Integer.parseInt(scanner.nextLine());
                                    if (LNAccountController.pinComment(loginUsername, selected))
                                        System.out.println("Comment successfully pinned!");
                                    else
                                        System.out.println("Couldn't pin comment");
                                }
                                catch (NumberFormatException e)
                                {
                                    System.out.println("Invalid selection");
                                }
                            }
                        }
                        else if (userInput == 6) // Remove Comment
                        {
                            int numCmts = LNAccountController.printComments(loginUsername);
                            if (numCmts == 0)
                                System.out.println("You have no comments to remove.");
                            else
                            {
                                System.out.println("Enter the number of the comment you want to remove: ");
                                int removed = Integer.parseInt(scanner.nextLine());
                                try
                                {
                                    if (LNAccountController.removeComment(loginUsername, removed))
                                        System.out.println("Comment successfully removed!");
                                    else
                                        System.out.println("Couldn't remove comment");
                                }
                                catch (NumberFormatException e)
                                {
                                    System.out.println("Invalid selection");
                                }
                            }
                        }
                        else if (userInput == 7) // Edit comment
                        {
                            int numCmts = LNAccountController.printComments(loginUsername);
                            if (numCmts == 0)
                                System.out.println("You have no comments to edit.");
                            else
                            {
                                System.out.println("Enter the number of the comment you want to edit: ");
                                int selected = Integer.parseInt(scanner.nextLine());
                                System.out.println("Enter the new text for the comment: ");
                                try
                                {
                                    String newText = scanner.nextLine();
                                    if (LNAccountController.editComment(loginUsername, selected, newText))
                                        System.out.println("Comment successfully edited!");
                                    else
                                        System.out.println("Couldn't edit comment");
                                }
                                catch (NumberFormatException e)
                                {
                                    System.out.println("Invalid selection");
                                }
                            }
                        }
                        else if (userInput == 8) // check notifications
                        {
                            if (LNAccountController.getNotifCount(loginUsername) == 0)
                                System.out.println("You have no notifications");
                            else
                            {
                                LNAccountController.printNotif(loginUsername);
                            }
                        }
                        else if (userInput == 9) // clear notifications
                        {
                            System.out.println("Clear all notifications? (press 1 to continue)");
                            userInput = Integer.parseInt(scanner.nextLine());
                            if (userInput == 1)
                            {
                                if (LNAccountController.clearNotifs(loginUsername))
                                    System.out.println("Notifiactions cleared");
                            }
                            else
                            {
                                System.out.println("Notifiactions not cleared");
                            }
                        }
                        else if (userInput == 10) // disable notifications
                        {
                            System.out.println("Disable notifacations? (press 1 to continue)");
                            userInput = Integer.parseInt(scanner.nextLine());
                            if (userInput == 1)
                            {
                                if (LNAccountController.disableNotifs(loginUsername))
                                    System.out.println("Notifiactions turned off");
                            }
                            else
                            {
                                System.out.println("Notifiactions will not be disabled");
                            }
                        }
                        else if (userInput == 11) // view a file
                        {
                            System.out.println("Enter ID of desired file");
                            LNFileController.previewFiles();
                            userInput = Integer.parseInt(scanner.nextLine());
                            for (int i = 0; i < LNFileController.previewFiles(); i++)
                            {
                                if (userInput == LNFileController.getFileList().get(i).getID())
                                {
                                    /* the code for viewing the file goes here */
                                    File selectFile = LNFileController.getFileList().get(i).getFile();
                                    LNFileController.viewFile(selectFile);
                                }
                                else
                                {
                                    System.out.println("Error - No ID match found");
                                }
                            }

                        }
                        else if (userInput == 12) // search for a comment
                        {
                            System.out.println("Enter a search term: ");
                            String search = scanner.nextLine();
                            LNAccountController.searchComments(search, loginUsername);
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Error: Please enter a number");
                    }
                }
                // User experience ends here
            }
        }
        // App ends here
        PrintWriter pw = new PrintWriter("accounts.csv");
        pw.print(""); // Clears file after use
        pw.close();
        scanner.close();
    }
}
