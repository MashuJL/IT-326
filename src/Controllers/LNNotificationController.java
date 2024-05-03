package Controllers;

import Models.LNNotification;
import CRUDOps.LNNotificationCRUDOps;
import Models.LNAccount;
import Handlers.LNNotificationHandler;

public class LNNotificationController
{

    private LNNotificationHandler notifHandler = new LNNotificationHandler();

    public boolean createNotification(int notifID, String titleText, String bodyText, LNAccount account)
    {

        return false;
    }

    public boolean deleteNotification(/* String ? */)
    {

        return false;
    }

    public LNNotificationHandler getNotificationCRUDOps()
    {
        return notifHandler;
    }

}
