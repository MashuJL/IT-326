public class folder
{
    private int folderID;
    private String name;
    private File[] fileList;
    private Account  owner;

    public int getFolderID()
    {
        return folderID;
    }
    
    public String getName()
    {
        return name;
    }

    public File[] getFileList()
    {
        return fileList;
    }

    public Account getOwner();
    {
        return owner;
    }
}
