package Handlers;

import CRUDOps.LNFolderCRUDOps;
import Models.*;
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
     * @throws IOException
     * @throws ClassNotFoundException
     * @return the folder
     */
    public LNFolder createFolder(String name, LNAccount owner) throws IOException, ClassNotFoundException
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
     * @param owner owner of the file
     * @return True if name is changed
     * @throws IOException
     */
    public Boolean renameFolder(String folder, String name, LNAccount owner) throws IOException
    {
        if(verify(folder))
        {
            LNFolder fol = folderLookUp(folder, owner);
            if(fol == null)
                return null;
            if(verify(name))
            {
                getFolOps().updateFolder(fol, fol.getFolderID(), name, fol.getOwner(), fol.getFileList());
                return true;
            }
            else
                return false;
        }
        else
            return false;

    }

    /**
     * Deletes the folder and the files inside the folder
     * @param folder the folder being deleted
     * @param owner owner of the folder
     * @return True when the folder is deleted
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public Boolean removeFolder(String folder, LNAccount owner) throws ClassNotFoundException, IOException
    {
        if(verify(folder))
        {
            LNFolder fol = folderLookUp(folder, owner);
            if(fol == null)
            return getFolOps().deleteFolder(fol);
        }
        else
            return false;
        return false;
    }

    private LNFolder folderLookUp(String name, LNAccount owner)
    {
        ArrayList<LNFolder> folders = owner.getFolders();
        for (int i=0;i < folders.size();i++) 
        {
            if (folders.get(i).getName().equals(name))  
                return folders.get(i);
        }
        return null;
    }
}
