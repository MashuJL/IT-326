package Models;
import java.io.Serializable;

public class LNFile implements Serializable
{
    //TODO: get the current version of LNFile - this is a stub
    private String name;

    public LNFile(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}
