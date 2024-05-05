package Operations;
import java.util.List;

import CRUDOps.LNFileCRUDOps;
import Models.LNAccount;
import Models.LNComment;
import Models.LNFile;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LNFileOperations extends LNFileCRUDOps{

    private ArrayList<LNFile> records;

    public boolean createFile(String name,int folder,int account){
        return records.add(new LNFile(name,folder,account));
    }
    public boolean deleteFile(LNFile deleted){
        if(records.remove(deleted)){
            deleted.deleteFile();
            return true;
        }
        else{
            return false;
        }
    }
    public LNFile getFile(int id){
        LNFile toGet = null;
        for (int i = 0; i < records.size(); i++) {
            toGet = records.get(i);
            if (toGet.getID()==id) {
                break;
            }
            else{
                toGet = null;
            }
        }
        return toGet;
    }
    public boolean updateFile(int FileID, String name, String folder, String contents){
        LNFile toGet = null;
        boolean noError= true;
        for (int i = 0; i < records.size(); i++) {
            toGet = records.get(i);
            if (toGet.getID()==FileID) {
                break;
            }
            else{
                toGet = null;
            }
        }
        if(toGet==null){
            return false;
        }
        if (name != null) {
            noError = toGet.setName(name);
        }
        if(contents!= null&&noError){
            noError = toGet.setContents(contents);
        }
        return noError;
    }
@Override
public ArrayList<LNFile> readFileCSV() throws IOException, ClassNotFoundException {
    try {
        FileInputStream files = new FileInputStream("files.csv");
        ObjectInputStream filesToFiles = new ObjectInputStream(files);
        return (ArrayList<LNFile>) filesToFiles.readObject();
    } catch (Exception e) {
        return null;
    }
}
@Override
public boolean writeFileCSV(ArrayList<File> files) throws IOException, ClassNotFoundException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'writeFileCSV'");
}
}
