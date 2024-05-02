import java.io.Serializable;

public class LNFolder implements Serializable
{
    private int folderID;
    private String name;
    private LNFile[] fileList;
    private LNAccount owner;

    public int getFolderID()
    {
        return folderID;
    }
    
    public String getName()
    {
        return name;
    }

    public LNFile[] getFileList()
    {
        return fileList;
    }

    public LNAccount getOwner();
    {
        return owner;
    }
}
