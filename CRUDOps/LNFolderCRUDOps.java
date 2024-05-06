package CRUDOps;

import java.io.IOException;

import Models.LNFolder;
import Models.LNAccount;
import Models.LNFile;


public abstract class LNFolderCRUDOps
{
    public abstract boolean createFolder(String nameString, LNAccount owner) throws IOException, ClassNotFoundException; //Creates a LNFolder object
    public abstract boolean saveFolder() throws IOException; //Saves the folder object
    public abstract boolean deleteFolder(LNFolder folderToDel) throws IOException, ClassNotFoundException; //Deletes a LNFolder object aswell as the contents inside the folder
    public abstract boolean updateFolder(LNFolder folder, int FolderID, String name, LNAccount owner, LNFile[] files) throws IOException; //Updates the desired information of the folder
}