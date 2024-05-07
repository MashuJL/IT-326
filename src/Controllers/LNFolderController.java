package Controllers;

import Handlers.LNFolderHandler;
import Models.LNAccount;
import Models.LNFolder;
import java.io.IOException;

public class LNFolderController 
{
    private static LNFolderHandler folHandler = null;

    private static LNFolderHandler getFolderHandlerInstance()
    {
        if (folHandler == null)
            folHandler = new LNFolderHandler();
        return folHandler;
    }

    public static LNFolder createFolder(String name, LNAccount owner) throws ClassNotFoundException, IOException
    {
        return getFolderHandlerInstance().createFolder(name, owner);
    }

    public static boolean renameFolder(String folder, String name, LNAccount owner) throws IOException
    {
        return getFolderHandlerInstance().renameFolder(folder, name, owner);
    }

    public static boolean removeFolder(String folder, LNAccount owner) throws IOException, ClassNotFoundException
    {
        return getFolderHandlerInstance().removeFolder(folder, owner);
    }
}
