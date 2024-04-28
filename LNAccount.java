import java.io.Serializable;

public class LNAccount implements Serializable 
{
    private String accountEmail;
    private String accountPassword;

    public LNAccount(String accountEmail, String accountPassword)
    {
        this.accountEmail = accountEmail;
        this.accountPassword = accountPassword;
    }

    public String getEmail()
    {
        return accountEmail;
    }

    public String getPassword()
    {
        return accountPassword;
    }
}
