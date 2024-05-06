package CRUDOps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import Models.LNFile;

public abstract class LNFileCRUDOps {
    public abstract ArrayList<LNFile> readFileCSV() throws IOException, ClassNotFoundException;
    public abstract boolean writeFileCSV(ArrayList<LNFile> files) throws IOException, ClassNotFoundException;
    public abstract boolean createFile(String name,int folder,int account) throws IOException, ClassNotFoundException;
    public abstract boolean deleteFile(LNFile deleted) throws IOException, ClassNotFoundException;
    public abstract LNFile getFile(String name,int folder,int account) throws IOException, ClassNotFoundException;
    public abstract LNFile getFileByID(int id) throws IOException, ClassNotFoundException;
    public abstract boolean downloadFile(String fileName, String folderName, LNFile toDownload) throws IOException;
    public abstract boolean updateFile(int FileID, String name, String contents) throws IOException, ClassNotFoundException;
    public abstract boolean moveFile(int FileID, int folder, int callingAccount) throws IOException, ClassNotFoundException;

    public abstract int previewFiles();

    public abstract ArrayList<LNFile> getFileList();

    public abstract int viewFile(File theFile);
}
