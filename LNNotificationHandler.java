public class LNNotificationHandler
{
    public int getID(LNNotification notif)
    {
        return notif.getID();
    }

    public String getTitle(LNNotification notif)
    {
        return notif.getTitle();
    }

    public String getBody(LNNotification notif)
    {
        return notif.getBody();
    }

    public LNAccount getAccount(LNNotification notif)
    {
        return notif.getAccount();
    }

    public boolean getUnread(LNNotification notif)
    {
        return notif.getUnread();
    }

    public boolean markNotifiactionAsRead(LNNotification notif)
    {
        if (notif.getUnread())
        {
            notif.markNotifiactionAsRead();
        }
        return false;
    }
}
