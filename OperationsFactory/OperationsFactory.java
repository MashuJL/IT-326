package OperationsFactory;
import CRUDOps.*;
import Operations.*;

public class OperationsFactory 
{
    public static LNFolderCRUDOps getFolOps()
    {
        return LNFolderOperations.getLNFolderOperationsInstance();
    }
}
