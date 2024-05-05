package Handlers;

import CRUDOps.LNCommentCRUDOps;
import Models.LNComment;
import OperationsFactory.OperationsFactory;

public class LNCommentHandler
{

    private boolean verify(int verifyInt) // Verifies parameter is an integer
    {
        try
        {
            Integer temp = (Integer) verifyInt;
            return true; // Cast succeeded, we have an integer. (instanceof doesnt work on primitves)
        }
        catch (Exception e)
        {
            return false; // Cast failed - not int
        }
    }

    public static LNCommentCRUDOps getCommOps()
    {
        return OperationsFactory.getCommOps();
    }

    public int printComment(int commentID)
    {

        return 0;
    }
}
