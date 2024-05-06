package Handlers;

import Models.*;
import CRUDOps.LNFolderCRUDOps;
import OperationsFactory.OperationsFactory;
import java.io.IOException;
import java.util.ArrayList;

public class LNFolderHandler 
{
    private boolean verify(String verfString)
    {
        return verfString instanceof String;
    }

    private boolean verify(int verfInt)
    {
        try
        {
            Integer temp = (Integer)verfInt;
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    public static LNFolderCRUDOps getFolOps()
    {
        return OperationsFactory.getFolOps();
    }

    /**
     * Method to get the files of the folder
     * @param folder the folder
     * @return the files
     */
    public ArrayList<LNFile> getFilesInFolder(LNFolder folder)
    {
        return folder.getFileList();
    }

    /**
     * Creates a new folder
     * @param name name of the folder
     * @param owner owner of the folder
     * @return the folder
     */
    public LNFolder createFolder(String name, LNAccount owner)
    {
        if(verify(name))
        {
            return getFolOps().createFolder(name, owner);
        }
        else
            return null;
    }

    /**
     * Renames the folder
     * @param folder LNFolder object
     * @param name new name
     * @return True if name is changed
     * @throws IOException
     */
    public Boolean renameFolder(LNFolder folder, String name) throws IOException
    {
        if(verify(name))
        {
            getFolOps().updateFolder(folder, folder.getFolderID(), name, folder.getOwner(), folder.getFileList());
            return true;
        }
        else
            return false;
    }

    /**
     * Deletes the folder and the files inside the folder
     * @param folder the folder being deleted
     * @return True when the folder is deleted
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public Boolean removeFolder(LNFolder folder) throws ClassNotFoundException, IOException
    {
        return getFolOps().deleteFolder(folder);
    }

}
