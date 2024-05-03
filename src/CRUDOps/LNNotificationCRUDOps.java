package CRUDOps;

import Models.LNAccount;
import Models.LNNotification;

public abstract class LNNotificationCRUDOps
{
    public abstract boolean createNotification(int notifID, String titleText, String bodyText, LNAccount account);

    public abstract boolean deleteNotification(LNNotification notif);

}
