import java.util.List;
import java.util.ArrayList;


public class LNFileOperations extends LNFileCRUDOps{
    private ArrayList<LNFile> records;

    public boolean createNotesFile(String name,LNFolder folder,LNAccount account){
        return records.add(new LNFile(name,folder,account));
    }
    public boolean deleteNotesFile(LNFile deleted){
        if(records.remove(deleted)){
            deleted.deleteNotesFile();
            return true;
        }
        else{
            return false;
        }
    }
    public LNFile getNotesFile(int id){
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
    public boolean updateNotesFile(int NotesFileID,String name,String folder){
        LNFile toGet = null;
        for (int i = 0; i < records.size(); i++) {
            toGet = records.get(i);
            if (toGet.getID()==NotesFileID) {
                break;
            }
            else{
                toGet = null;
            }
        }
        if(toGet==null){
            return false;
        }
        if(name != null){
            toGet.renameNotesFile(name);
        }
        
    }
public String getName(){}
public int getID(){}
public LNFile createFile(){}
public void renameFile(String name){}
public void downloadFile(String downloadName){}
public boolean moveFile(String folderName){}
public LNFile getFile(){}
public LNAccount getAccount(){}
public List<LNComment> getComments(){}
}
