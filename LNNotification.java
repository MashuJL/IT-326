public class LNNotification
{

    private int notifID;
    private String bodyText;
    private String titleText;
    private LNAccount account;
    public boolean unread;

    public LNNotification(int notifID, String bodyText, String titleText, LNAccount account)
    {
        this.notifID = notifID;
        this.bodyText = bodyText;
        this.titleText = titleText;
        this.account = account;
        unread = true;
    }

    public int getID()
    {
        return notifID;
    }

    public void detectActivity()
    {
        return;
    }

    public String getTitle()
    {
        return titleText;
    }

    public String getBody()
    {
        return bodyText;
    }

    public LNAccount getAccount()
    {
        return account;
    }

}
