import java.io.File;
import java.util.List;

public class LNFile {
    private int NotesFileID;
private String name;
private String content;
private File actualFile;
private LNFolder folder;
private LNAccount account;
private List<LNComment> comments;

public LNFile(String name, LNFolder folder){
    this.name = name;
    this.folder = folder;
    actualFile = new File()
}

//return name of file.
public String getName(){
    return name;
}
//return id of file.
public int getID(){
    return NotesFileID;
}
public void deleteNotesFile(){
    actualFile.delete();
}
public void renameNotesFile(String name){
    this.name = name;
    File newFile = new File(actualFile,name);
    actualFile.delete();
    actualFile = newFile;
}

//this will allow user to download the file to another location.
public void downloadNotesFile(String downloadName){
    File makeFile = new File(actualFile, downloadName);
}
public LNFile getFile(){

    return this;
}

public LNAccount getAccount(){}
public List<LNComment> getComments(){}
public boolean addComment(){}

}
