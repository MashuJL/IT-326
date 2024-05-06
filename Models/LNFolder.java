package Models;

import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;

public class LNFolder implements Serializable
{
    private int folderID;
    private String name;
    private ArrayList<LNFile> fileList;
    private LNAccount owner;

    public LNFolder(String name, LNAccount owner)
    {
        Random rand = new Random();
        this.folderID = -1;
        this.name = name;
        this.owner = owner;
        boolean alreadyID = true;
        ArrayList<LNFolder> folders = owner.getFolders();
        while(alreadyID == true)
        {
            alreadyID = false;
            this.folderID = rand.nextInt(1000);
            if(folders != null)
            {
                for(int i = 0; i < folders.size(); i++)
                {
                    if(folders.get(i).getFolderID() == this.folderID)
                        alreadyID = true;
                }
            }
        }
    }

    public int getFolderID()
    {
        return folderID;
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public LNFile[] getFileList()
    {
        return fileList;
    }

    public void setFileList(LNFile[] files)
    {
        fileList = files;
    }

    public LNAccount getOwner()
    {
        return owner;
    }

    public void setOwner(LNAccount newOwner)
    {
        this.owner = newOwner;
    }
}
