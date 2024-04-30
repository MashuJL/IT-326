// import java.io.EOFException;
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
// import java.net.SocketTimeoutException;
// import java.util.ArrayList;

// public class LNUserOperations extends LNUserCRUDOps
// {
//     public LNUser retrieveUser(int ID) throws IOException, ClassNotFoundException
//     {
//         FileInputStream fileStream = new FileInputStream("user.csv");
//         ObjectInputStream objStream = new ObjectInputStream(fileStream);
//         LNUser user = (LNUser) objStream.readObject();
//         if(user != null)
//         {
//             if(user.getID() == ID)
//             {
//                 objStream.close();
//                 fileStream.close();
//                 return user;
//             }
//         }
//         System.out.println("Error: No user made or could not find user. Returning null");
//         objStream.close();
//         fileStream.close();
//         return null;
//     }

//     public boolean saveUser(int ID, ArrayList<LNAccount> accts)
//     {
//         File csvFile = new File("user.csv");
//         LNUser user = new LNUser(ID, accts);

//         try(FileOutputStream fos = new FileOutputStream(csvFile); ObjectOutputStream oos = new ObjectOutputStream(fos))
//         {
//             oos.writeObject(user);
//             oos.flush();
//             return true;
//         } catch (Exception e)
//         {
//             return false;
//         }
//     }

//     public boolean deleteUser(int ID) throws IOException, ClassNotFoundException
//     {
//         LNUser tempUser= retrieveUser(ID);
//         if(tempUser != null)
//         {
//             tempUser = null;
//             saveUser(tempUser.getID(), tempUser.getAccounts());
//             return true;
//         }
//         return false;
//     }

//     public boolean updateUser(int ID, int curID) throws IOException, ClassNotFoundException
//     {
//         LNUser tempUser = retrieveUser(curID);
//         if(tempUser != null)
//         {
//             saveUser(ID, tempUser.getAccounts());
//             return true;
//         }
//         return false;
//     }
// }
