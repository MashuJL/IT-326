package Operations;

import CRUDOps.LNNotificationCRUDOps;
import Classes.LNAccount;
import Classes.LNNotification;

public class LNNotificationOperations
{

    private LNNotificationCRUDOps notificationOps;

    public boolean createNotification(int notifID, String titleText, String bodyText, LNAccount account)
    {
        LNNotification notif = new LNNotification(notifID, bodyText, titleText, account);
        return true;
    }

    public boolean deleteNotification(LNNotification notif)
    {
        notif = null;
        return true;
    }

    public LNNotificationCRUDOps getLnNotificationOperationsInstance()
    {
        return notificationOps;
    }

}
