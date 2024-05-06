package Handlers;

import Models.*;
import CRUDOps.LNFolderCRUDOps;
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

    /**
     * Method to get the files of the folder
     * @param folder the folder
     * @return the files
     */
    public ArrayList<LNFile> getFilesInFolder(LNFolder folder)
    {
        return folder.getFileList();
    }

    public Boolean renameFolder(LNFolder folder, String name)
    {
        if(verify(name))
        {
            folder.updateFolder(folder, folder.getFolderID(), folder.getOwner(), folder.getFileList());
        }
    }
}
