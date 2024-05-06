package Controllers;

import java.io.File;
import java.util.ArrayList;

import Handlers.LNFileHandler;
import Models.LNFile;

public class LNFileController
{
    private static LNFileHandler fileHandler = null;

    private static LNFileHandler getLNFileHandlerInstance()
    {
        if (fileHandler == null)
            fileHandler = new LNFileHandler();
        return fileHandler;
    }

    public static int previewFiles()
    {
        return getLNFileHandlerInstance().previewFiles();
    }

    public static ArrayList<LNFile> getFileList()
    {
        return getLNFileHandlerInstance().getFileList();
    }

    public static int viewFile(File theFile)
    {
        return getLNFileHandlerInstance().viewFile(theFile);
    }

}
