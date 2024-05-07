package OperationsFactory;

import CRUDOps.LNAccountCRUDOps;
import CRUDOps.LNCommentCRUDOps;
import CRUDOps.LNFileCRUDOps;
import CRUDOps.LNFolderCRUDOps;
import CRUDOps.LNNotificationCRUDOps;
import Operations.LNAccountOperations;
import Operations.LNCommentOperations;
import Operations.LNFileOperations;
import Operations.LNFolderOperations;
import Operations.LNNotificationOperations;

public class OperationsFactory
{
    public static LNAccountCRUDOps getAcctOps()
    {
        return LNAccountOperations.getLNAccountOperationsInstance();
    }

    public static LNNotificationCRUDOps getNotifOps()
    {
        return LNNotificationOperations.getLNNotificationOperationsInstance();
    }

    public static LNCommentCRUDOps getCommOps()
    {
        return LNCommentOperations.getLNCommentOperationsInstance();
    }

    public static LNFileCRUDOps getFileOps()
    {
        return LNFileOperations.getLNFileOperationsInstance();
    }

    public static LNFolderCRUDOps getFolOps()
    {
        return LNFolderOperations.getLNFolderOperationsInstance();
    }
}
