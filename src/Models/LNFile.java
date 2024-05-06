package Models;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class LNFile implements Serializable
{
    // TODO: get the current version of LNFile - this is a stub
    private int fileID;
    private String name;
    private String contents;
    private File actualFile;
    private LNFolder folder;
    private LNAccount account;
    private ArrayList<LNComment> comments;

    public LNFile(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public File getFile()
    {
        return this.actualFile;
    }

    public int getID()
    {
        return this.fileID;
    }

    public LNAccount getAccount()
    {
        return this.account;
    }

    public ArrayList<LNComment> getComments()
    {
        return this.comments;
    }
}
