public class LNNotificationController
{

    private LNNotificationHandler notifHandler = new LNNotificationHandler();

    public int getID(LNNotification notif)
    {
        return notifHandler.getID(notif);
    }

    public String getTitle(LNNotification notif)
    {
        return notifHandler.getTitle(notif);
    }

    public String getBody(LNNotification notif)
    {
        return notifHandler.getBody(notif);
    }

    public LNAccount getAccount(LNNotification notif)
    {
        return notifHandler.getAccount(notif);
    }

    public boolean getUnread(LNNotification notif)
    {
        return notif.getUnread();
    }

    public boolean markNotifiactionAsRead(LNNotification notif)
    {
        return notifHandler.markNotifiactionAsRead(notif);
    }
}
