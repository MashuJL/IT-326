package Classes;
import java.io.Serializable;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class LNFile implements Serializable{
private int FileID;
private String name;
private String content;
private File actualFile;
private int folderID; 
private int accountID;
private List<LNComment> comments;

public LNFile(String name, int folderID, int accountID){
    this.name = name;
    this.folderID = folderID;
    this.accountID = accountID;
    actualFile = new File(name);
}

public LNFile(String name, int folderID, int accountID,File actualFile){
    this.name = name;
    this.folderID = folderID;
    this.accountID = accountID;
    this.actualFile = actualFile;
}

//return name of file.
public String getName(){
    return name;
}
//return id of file.
public int getID(){
    return FileID;
}
public void deleteFile(){
    actualFile.delete();
    comments = null;
}
public void renameFile(String name){
    this.name = name;
    File newFile = new File(actualFile,name);
    actualFile.delete();
    actualFile = newFile;
}

//this will allow user to download the file to another location.
public void downloadFile(String downloadName){
    File makeFile = new File(actualFile, downloadName);
}
public File getFile(){
    return this.actualFile;
}

public int getAccountID(){
    return accountID;
}
public List<LNComment> getComments(){
    return comments;
}
public boolean addComment(LNComment e){
    comments.add(e);
    return true;
}

public boolean setName(String name){
    File renamFile = new File(actualFile, name);
    if (actualFile.delete()) {
        actualFile = renamFile;
        return true;
    } else {
        return false;
    }

}
public boolean setContents(String contents){
    if(contents ==null){
        return true;
    }
    try {
        FileWriter write = new FileWriter(actualFile);
        write.write(contents);
        write.close();
        return true;
    } catch (Exception e) {
        return false;
    }
}

public int getFileID() {
    return FileID;
}

public void setFileID(int fileID) {
    FileID = fileID;
}

public String getContent() {
    return content;
}

public void setContent(String content) {
    this.content = content;
}

public File getActualFile() {
    return actualFile;
}

public void setActualFile(File actualFile) {
    this.actualFile = actualFile;
}

public int getFolderID() {
    return folderID;
}

public void setFolderID(int folderID) {
    this.folderID = folderID;
}

public void setAccountID(int accountID) {
    this.accountID = accountID;
}

public void setComments(List<LNComment> comments) {
    this.comments = comments;
}

}
