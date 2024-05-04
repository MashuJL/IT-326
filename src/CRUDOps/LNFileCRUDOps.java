package CRUDOps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Classes.LNFile;

public abstract class LNFileCRUDOps {
    public abstract ArrayList<LNFile> readFileCSV() throws IOException, ClassNotFoundException;
    public abstract boolean writeFileCSV(ArrayList<File> files) throws IOException, ClassNotFoundException;
    public abstract boolean createFile(String name,int folder,int account);
    public abstract boolean deleteFile(LNFile deleted);
    public abstract LNFile getFile(int id);
    public abstract boolean updateFile(int FileID,String name,String folder,String contents);
}
