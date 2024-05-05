package OperationsFactory;

import CRUDOps.LNAccountCRUDOps;
import CRUDOps.LNCommentCRUDOps;
import CRUDOps.LNNotificationCRUDOps;
import Operations.LNAccountOperations;
import Operations.LNCommentOperations;
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

    // public static LNCommentCRUDOps getCommOps()
    // {
    // return LNCommentOperations.getLNAccountOperationsInstance();
    // }
}
