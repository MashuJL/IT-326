package Handlers;
import java.io.IOException;
import CRUDOps.LNFileCRUDOps;
import Models.LNFile;
import OperationsFactory.OperationsFactory;

public class LNFileHandler {

    public static LNFileCRUDOps getFileOps() //
    {
        return OperationsFactory.getFileOps();
    }
    public boolean uploadFile(String name, int folderID, int accountID) throws ClassNotFoundException, IOException{
        if(verify(name)&&verify(folderID)&&verify(accountID))
        return getFileOps().createFile(name, folderID, accountID);
        else
        return false;
    }
    public boolean removeFile(LNFile file) throws ClassNotFoundException, IOException{
        if(verify(file))
        return getFileOps().deleteFile(file);
        else
        return false;
    }
    public boolean moveFile(LNFile file, int destination,int account) throws ClassNotFoundException, IOException{
        if(verify(file)&&verify(destination)&&verify(account))
        return getFileOps().moveFile(file.getFileID(), destination, account);
        else
        return false;
    }
    public boolean updateFile(int id,String name,String contents) throws ClassNotFoundException, IOException{
        if(verify(id)&&verify(name)&&verify(contents))
        return getFileOps().updateFile(id, name, contents);
        else
        return false;
    }
    public boolean downloadFile(String name, String folder, LNFile file) throws IOException{
        if(verify(name)&&verify(folder)&&verify(file))
        return getFileOps().downloadFile(name, folder, file);
        else
        return false;
    }
    private boolean verify(String verifyStr){
        return verifyStr instanceof String;
    }
    private boolean verify(Integer verifyInt){
        return verifyInt instanceof Integer;
    }
    private boolean verify(LNFile verifyFile){
        return verifyFile instanceof LNFile;
    }


    public static LNFileCRUDOps getFileOps()
    {
        return OperationsFactory.getFileOps();
    }

    private boolean verify(int verifyInt)
    {
        try
        {
            Integer temp = (Integer) verifyInt;
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public int previewFiles()
    {
        return getFileOps().previewFiles();
    }

    public ArrayList<LNFile> getFileList()
    {
        return getFileOps().getFileList();
    }

    public int viewFile(File theFile)
    {
        return getFileOps().viewFile(theFile);
    }

}
