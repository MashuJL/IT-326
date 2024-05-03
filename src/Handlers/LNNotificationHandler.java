package Handlers;

import CRUDOps.LNNotificationCRUDOps;
import Models.LNAccount;
import Models.LNNotification;
import OperationsFactory.OperationsFactory;

public class LNNotificationHandler
{
    private boolean verify(String verifyStr)
    {
        return verifyStr instanceof String;
    }

    public boolean createNotification(int notifID, String titleText, String bodyText, LNAccount account)
    {

        return false;
    }

    public boolean deleteNotification(/* String ? */)
    {

        return false;
    }

    public LNNotificationCRUDOps getNotifOps()
    {
        return OperationsFactory.getNotifOps();
    }
}
