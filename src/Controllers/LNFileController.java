package Controllers;

import java.io.File;
import java.util.List;

import Models.LNFile;
import Models.LNFolder;
import Handlers.LNFileHandler;

import java.util.List;


public class LNFileController {
        private static LNFileHandler handler = null;

    public static LNFileHandler getLNFileHandlerInstance(){
        if(handler==null)
            handler = new LNFileHandler();
        return handler;
    }
    public List<LNFile> getFilesInFolder(LNFolder folder){
        return handler.getFilesInFolder(folder);
    }
//finalize, save it.
public Boolean uploadFile(String name, LNFile file){
    return handler.uploadFile(name, file);
}
public boolean removeFile(LNFile file){
    return handler.removeFile(file);
}
public boolean moveFile(LNFile file, LNFolder destination){
    return handler.moveFile(file, destination);
}
//when call update file, in that method you will ask user what they will want to change,title, text
public boolean updateFile(String name,String contents){
    return handler.updateFile(name, contents);
}
public boolean downloadFile(String name, LNFile file){
    return handler.downloadFile(name, file);
}

}
