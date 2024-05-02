public class LNFolderHandler 
{
    public void createFolder(String name)
    {
        LNFolderCRUDOps.saveFolder(name);
        this.fl = new LNFolder();
    }

    public void renameFolder()
    {

    }

    public void deleteFolder()
    {

    }    
}
