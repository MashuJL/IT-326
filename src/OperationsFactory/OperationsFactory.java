package OperationsFactory;

import CRUDOps.LNAccountCRUDOps;
import CRUDOps.LNFileCRUDOps;
import CRUDOps.LNCommentCRUDOps;
import CRUDOps.LNNotificationCRUDOps;
import CRUDOps.LNFileCRUDOps;
import Operations.LNAccountOperations;
import Operations.LNFileOperations;
import Operations.LNCommentOperations;
import Operations.LNNotificationOperations;
import Operations.LNFileOperations;

public class OperationsFactory
{
    public static LNAccountCRUDOps getAcctOps()
    {
        return LNAccountOperations.getLNAccountOperationsInstance();
    }

    public static LNFileCRUDOps getFileOps() {
        return LNFileOperations.getLNFileOperationsInstance();
    }

    public static LNNotificationCRUDOps getNotifOps()
    {
        return LNNotificationOperations.getLNNotificationOperationsInstance();
    }

    public static LNCommentCRUDOps getCommOps()
    {
        return LNCommentOperations.getLNCommentOperationsInstance();
    }

}
