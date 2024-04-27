import java.util.List;

public class LNFile {
    private int NotesFileID;
private String name;
private String contents;
private Folder folder;
private LNAccount account;
private List<LNComment> comments;

public String getName(){
    return name;
}
public int getID(){
    return NotesFileID;
}
public void deleteNotesFile(){}
public void renameNotesFile(String name){
    this.name = name;
}
public void downloadNotesFile(String downloadName){

}
public LNFile getFile{}
public LNAccount getAccount{}
public List<LNComment> getComments{}
}
