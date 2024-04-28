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

    public boolean markNotifiactionAsRead(LNNotification notif)
    {
        if (notif.unread)
        {
            notif.unread = false;
            return true;
        }
        return false;
    }
}
