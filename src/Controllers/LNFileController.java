package Controllers;

import java.io.IOException;

import Models.LNFile;
import Handlers.LNFileHandler;


public class LNFileController {
        private static LNFileHandler handler = null;

    public static LNFileHandler getLNFileHandlerInstance(){
        if(handler==null)
            handler = new LNFileHandler();
        return handler;
    }
//finalize, save it.
public Boolean uploadFile(String name, int folderID, int accountID) throws ClassNotFoundException, IOException{
    return handler.uploadFile(name, folderID, accountID);
}
public boolean removeFile(LNFile file) throws ClassNotFoundException, IOException{
    return handler.removeFile(file);
}
public boolean moveFile(LNFile file, int destination,int account) throws ClassNotFoundException, IOException{
    return handler.moveFile(file, destination,account);
}
//when call update file, in that method you will ask user what they will want to change,title, text
public boolean updateFile(int id,String name,String contents) throws ClassNotFoundException, IOException{
    return handler.updateFile(id,name, contents);
}
public boolean downloadFile(String name, String folder, LNFile file) throws IOException{
    return handler.downloadFile(name, folder, file);
}

}
