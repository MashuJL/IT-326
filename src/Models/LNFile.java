package Models;
import java.io.Serializable;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import CRUDOps.LNFileCRUDOps;
import Operations.LNFileOperations;

public class LNFile implements Serializable{
private int FileID;
private String name;
private String content;
private int folderID; 
private int accountID;
private List<LNComment> comments;



public LNFile(String name, int folderID, int accountID){
    this.name = name;
    this.folderID = folderID;
    this.accountID = accountID;
    FileID = generateID();
    content = "";
}

public LNFile(String name, int folderID, int accountID,String contents){
    this.name = name;
    this.folderID = folderID;
    this.accountID = accountID;
    FileID = generateID();
    content = contents;
}

private int generateID(){
    Random gen = new Random();
    int ID =-1;
    while(ID==-1){
        ID = gen.nextInt(10000);
        try {
            if(getFileOps().getFileByID(ID)!= null){
                ID = -1;
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    return ID;
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
    comments = null;
}
public void renameFile(String name){
    this.name = name;
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
    this.name = name;
    return true;
}
public boolean setContents(String contents){
    content = contents;
    return true;
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

    public static LNFileCRUDOps getFileOps()
    {
        return LNFileOperations.getLNFileOperationsInstance();
    }

}
