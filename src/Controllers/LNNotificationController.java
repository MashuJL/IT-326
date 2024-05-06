package Controllers;

import Models.LNNotification;
import CRUDOps.LNNotificationCRUDOps;
import Models.LNAccount;
import Handlers.LNNotificationHandler;

public class LNNotificationController
{

    private LNNotificationHandler notifHandler = new LNNotificationHandler();

    private LNNotificationHandler getNotificationHandler()
    {
        return notifHandler;
    }

    public boolean createNotification(int notifID, String titleText, String bodyText, LNAccount account)
    {
        return getNotificationHandler().createNotification(notifID, titleText, bodyText, account);
    }

    public boolean deleteNotification(LNNotification notif)
    {
        return getNotificationHandler().deleteNotification(notif);
    }

}
