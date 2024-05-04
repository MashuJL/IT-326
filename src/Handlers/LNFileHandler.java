package Handlers;
import java.io.File;
import java.util.List;

import CRUDOps.LNAccountCRUDOps;
import CRUDOps.LNFileCRUDOps;
import Models.LNFile;
import Models.LNFolder;
import Controllers.LNFolderController;
import OperationsFactory.OperationsFactory;

public class LNFileHandler {

    public static LNFileCRUDOps getFileOps() //
    {
        return OperationsFactory.getFileOps();
    }

    public List<LNFile> filesInFolder getFilesInFolder(LNFolder folder){
        return getFileOps().getFilesInFolder(folder);
    }
    public boolean uploadFile(String name, int folderID, int accountID, List<LNFile> filesInFolder){
        return getFileOps().createFile(name, folderID, accountID);
    }
    public boolean removeFile(LNFile file){
        return getFileOps().deleteFile(file);
    }
    public boolean moveFile(LNFile file, String destination,List<LNFile> filesInFolder){
        return getFileOps().updateFile(file.getFileID(), null, destination, null);
    }
    public boolean updateFile(int id,String name,String contents,List<LNFile> filesInFolder){
        return getFileOps().updateFile(id, name, null, contents);
    }
    public boolean downloadFile(String name, LNFile file){
        return getFileOps().;
    }
    private boolean verify(){
        return true;
    }
    
}
