package Handlers;
import java.io.File;
import java.util.List;

import CRUDOps.LNFileCRUDOps;
import Classes.LNFile;
import Classes.LNFolder;
import Controllers.LNFolderController;

public class LNFileHandler {
    public List<LNFile> getFilesInFolder(LNFolder folder){
        return LNFolderController.getFilesInFolder(folder);
    }
    public boolean uploadFile(String name, LNFile NotesFile){
        return LNFileCRUDOps.
    }
    public boolean removeFile(LNFile file){

    }
    public boolean moveFile(LNFile file, LNFolder destination){
    
    }
    public boolean updateFile(String name,String contents){
    
    }
    public boolean downloadFile(String name, LNFile file){
    
    }
    private boolean verify(){
        return true;
    }
    
}
