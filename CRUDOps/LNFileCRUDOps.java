package CRUDOps;

import Classes.LNFile;

public abstract class LNFileCRUDOps {
    public abstract boolean createFile(String name,int folder,int account);
    public abstract boolean deleteFile(LNFile deleted);
    public abstract LNFile getFile(int id);
    public abstract boolean updateFile(int FileID,String name,String folder);
}
