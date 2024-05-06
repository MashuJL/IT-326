package Operations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import CRUDOps.LNFileCRUDOps;
import Models.LNFile;

public class LNFileOperations extends LNFileCRUDOps
{

    private ArrayList<LNFile> records;
    private static LNFileCRUDOps fileOps = null;

    public static LNFileCRUDOps getLNFileOperationsInstance()
    {
        if (fileOps == null)
            fileOps = new LNFileOperations();
        return fileOps;
    }

    public ArrayList<LNFile> readFileCSV() throws IOException, ClassNotFoundException
    {
        try
        {
            FileInputStream files = new FileInputStream("files.csv");
            ObjectInputStream filesToFiles = new ObjectInputStream(files);
            return (ArrayList<LNFile>) filesToFiles.readObject();
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public int previewFiles()
    {
        for (int i = 0; i < records.size(); i++)
        {
            System.out.println("ID:" + records.get(i).getID() + ", Name: " + records.get(i).getName());
        }
        return records.size();
    }

    public ArrayList<LNFile> getFileList()
    {
        return records;
    }

    public int viewFile(File theFile)
    {
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(theFile));
            String line;
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (reader != null)
                {
                    reader.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
