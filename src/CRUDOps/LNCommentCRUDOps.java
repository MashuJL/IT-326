package CRUDOps;

import java.util.ArrayList;

import Models.LNAccount;
import Models.LNFile;
import Models.LNComment;

public abstract class LNCommentCRUDOps
{
    public abstract boolean saveComment(int commentID, String commentText, LNAccount owner, LNFile file,
            ArrayList<LNComment> replies);

    public abstract boolean deleteComment(int commentID);

    public abstract LNComment retreiveComment(int commentID);

    public abstract boolean updateComment(int commentID, String newData);
}
