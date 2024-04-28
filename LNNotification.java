public class LNNotification
{

    private int notifID;
    private String bodyText;
    private String titleText;
    private LNAccount account;

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
