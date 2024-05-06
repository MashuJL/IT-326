package Handlers;

import java.util.ArrayList;
import java.io.File;

import CRUDOps.LNFileCRUDOps;
import Models.LNFile;
import OperationsFactory.OperationsFactory;

public class LNFileHandler
{

    public static LNFileCRUDOps getFileOps()
    {
        return OperationsFactory.getFileOps();
    }

    private boolean verify(int verifyInt)
    {
        try
        {
            Integer temp = (Integer) verifyInt;
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public int previewFiles()
    {
        return getFileOps().previewFiles();
    }

    public ArrayList<LNFile> getFileList()
    {
        return getFileOps().getFileList();
    }

    public int viewFile(File theFile)
    {
        return getFileOps().viewFile(theFile);
    }

}
