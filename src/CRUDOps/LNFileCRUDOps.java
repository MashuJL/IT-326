package CRUDOps;

import java.io.File;
import java.util.ArrayList;

import Models.LNFile;

public abstract class LNFileCRUDOps
{
    public abstract int previewFiles();

    public abstract ArrayList<LNFile> getFileList();

    public abstract int viewFile(File theFile);
}
