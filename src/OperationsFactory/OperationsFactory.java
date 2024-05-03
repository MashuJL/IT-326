package OperationsFactory;

import CRUDOps.LNAccountCRUDOps;
import CRUDOps.LNNotificationCRUDOps;
import Operations.LNAccountOperations;
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
}
