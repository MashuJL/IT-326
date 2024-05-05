package Controllers;

import Handlers.LNAccountHandler;
import Handlers.LNCommentHandler;

public class LNCommentController
{
    private static LNCommentHandler commHandler = null;

    private static LNCommentHandler getLNCommentHandlerInstance()
    { // Gets the comment handler object
        if (commHandler == null)
            commHandler = new LNCommentHandler();
        return commHandler;
    }

    public static int printComment(int commentID)
    {
        return getLNCommentHandlerInstance().printComment(commentID);
    }
}
