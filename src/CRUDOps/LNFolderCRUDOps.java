package CRUDOps;

import Models.LNAccount;
import Models.LNFile;
import Models.LNFolder;
import java.io.IOException;
import java.util.ArrayList;


public abstract class LNFolderCRUDOps
{
    public abstract LNFolder createFolder(String nameString, LNAccount owner) throws IOException, ClassNotFoundException; //Creates a LNFolder object
    public abstract boolean saveFolder() throws IOException; //Saves the folder object
    public abstract boolean deleteFolder(LNFolder folderToDel) throws IOException, ClassNotFoundException; //Deletes a LNFolder object aswell as the contents inside the folder
    public abstract boolean updateFolder(LNFolder folder, int FolderID, String name, LNAccount owner, ArrayList<LNFile> files) throws IOException; //Updates the desired information of the folder
}