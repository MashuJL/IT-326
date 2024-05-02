import java.io.IOException;

public abstract class LNFolderCRUDOps
{
    public abstract LNFolder createFolder(String nameString) throws IOException;
    public abstract boolean saveFolder() throws IOException;
    public abstract boolean deleteFolder() throws IOException;
    public abstract boolean updateFolder() throws IOException;
}