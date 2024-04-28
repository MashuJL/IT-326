import java.util.List;

public class LNFileController {
    private LNFileHandler handler = new LNFileHandler();
    public List<LNFile> getNotesFilesInFolder(LNFolder folder){
        return handler.getNotesFilesInFolder(folder);
    }
public List<LNFolder> getFoldersFromAccount(LNAccount account){
    return handler.getFoldersFromAccount(account);
}
public Boolean uploadNotesFile(String name, LNFile file){
    return handler.uploadNotesFile(name, file);
}
}
