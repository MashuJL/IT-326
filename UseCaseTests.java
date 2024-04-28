import java.lang.reflect.Array;
import java.util.ArrayList;

public class UseCaseTests {

    public UseCaseTests() {}

    private class FakeUser{

        int uid;

        public FakeUser(int uid)
        {
            this.uid = uid;
        }
    
    }

    private class FUController{

    }

    private class FUHandler{

    }

    public static class FakeComment{

        int cid;
        String ctitle;
        String cbody;

        public FakeComment(int cid, String ctitle, String cbody)
        {
            this.cid = cid;
            this.ctitle = ctitle;
            this.cbody = cbody;
        }

    }

    private class FCController{

    }

    private class FCHandler{

    }

    public static class FakeAcct{
        
        int aid;
        String email;
        String pass;
        ArrayList<FakeComment> allCmts = new ArrayList<FakeComment>();
        ArrayList<FakeComment> pinnedCmts = new ArrayList<FakeComment>();
        ArrayList<Integer> blacklist = new ArrayList<Integer>();
        FAHandler handler; 

        public FakeAcct(int aid, String email, String pass)
        {
            this.aid = aid;
            this.email = email;
            this.pass = pass;
            //this.handler = handler;
        }
        public void setHandler(FAHandler handler)
        {
            this.handler = handler;
        }
        public int getID()
        {
            return this.aid;
        }
        public String getEmail()
        {
            return this.email;
        }
        public String getPasS()
        {
            return this.pass;
        }
        public ArrayList<FakeComment> getAllComments()
        {
            return this.allCmts;
        }
        public ArrayList<FakeComment> getPinned()
        {
            return this.pinnedCmts;
        }
        public ArrayList<Integer> getBlacklist()
        {
            return this.blacklist;
        }
        public void setID(int id)
        {
            this.aid = id;
        }
        public void setEmail(String email)
        {
            this.email = email;
        }
        public void setPassword(String password)
        {
            this.pass = password;
        }

    }

    public static class FAController{

        private FAHandler handler;

        public FAController(FAHandler handler)
        {
            this.handler = handler;
        }

        public boolean blockUser(int id)
        {
            return handler.blockUser(id);
        }
        public boolean unblockUser(int id)
        {
            return handler.unblockUser(id);
        }
        public boolean pinComment(FakeComment cmt)
        {
            return handler.pinComment(cmt);
        }
        public boolean removeComment(FakeComment cmt)
        {
            return handler.removeComment(cmt);
        }
        public boolean editComment(FakeComment cmt, String newTitle, String newBody)
        {
            return handler.editComment(cmt, newTitle, newBody);
        }
        public boolean addComment(FakeComment cmt)
        {
            return handler.addComment(cmt);
        }

    }

    public static class FAHandler{

        private FakeAcct acct;
        
        public FAHandler(FakeAcct acct)
        {
            this.acct = acct;
        }
        public boolean blockUser(int id)
        {
            if(acct.getBlacklist().contains((Integer)id))
                return false; //User already blocked
            if(acct.getBlacklist().add((Integer)id))
                return true;
            return false;
        }
        public boolean unblockUser(int id)
        {
            if(acct.getBlacklist().remove((Integer)id))
                return true;
            return false;
        }
        public boolean pinComment(FakeComment cmt)
        {
            if(acct.getPinned().add(cmt))
                return true;
            return false;
        }
        public boolean removeComment(FakeComment cmt)
        {
            acct.getPinned().remove(cmt);
            if(acct.getAllComments().remove(cmt))
                return true;
            return false;
        }
        public boolean editComment(FakeComment cmt, String title, String body)
        {
            int index = acct.getAllComments().indexOf(cmt);
            if(index == -1)
                return false;
            acct.getAllComments().get(index).ctitle = title;
            acct.getAllComments().get(index).cbody = body; //In the real program these would be set methods, not direct access
            return true;
        }
        public boolean addComment(FakeComment cmt)
        {
            if(acct.getAllComments().add(cmt))
                return true;
            return false;
        }

    }
    
    public static void main(String[] args) {
        FakeAcct testAcct = new FakeAcct(1, "sample@test.com", "12345");
        FAHandler testHandler = new FAHandler(testAcct);
        FAController testController = new FAController(testHandler);
        testAcct.setHandler(testHandler);

        FakeComment testCmt1 = new FakeComment(1, "test 1", "abcde\nfghij\nklmno");
        FakeComment testCmt2 = new FakeComment(2, "the second one", "1234\n5678\n;khfkjlegy!");
        FakeComment testCmt3 = new FakeComment(3, "shrek the third", "dljfhkjfhkfityeygshjdgfjeyfgjsgh3jtf3"); 

        boolean temp = false;

        //Not a use case (for me) but testing functionality
        System.out.println("Adding the first comment:");
        temp = testController.addComment(testCmt1);
        if(temp)
            System.out.println("TestCmt1 added successfully");
        else
            System.out.println("TestCmt1 addition failed");

        System.out.println("Adding the rest");
        testController.addComment(testCmt2);
        testController.addComment(testCmt3);
        for (FakeComment fc : testAcct.getAllComments()) {
            System.out.println("Title: "+fc.ctitle);
            System.out.println("Text: "+fc.cbody+"\n\n\n");
        }

        //Blocking user
        System.out.println("Blocking user with id = 15");
        temp = testController.blockUser(15);
        if(temp)
            System.out.println("Blocked user ID = 15 successfully");
        else
            System.out.println("Failed to block user ID = 15");
        //Attemping to block user again. This should fail becasue they're already blocked.
        System.out.println("Attemping to block user again. This should fail because they're already blocked.");
        temp = testController.blockUser(15);
        if(temp)
            System.out.println("Blocked user ID = 15. This is an error");
        else
            System.out.println("User ID = 15 is already blocked.");
        //Blocking some more IDs
        testController.blockUser(12);
        testController.blockUser(9);
        testController.blockUser(24);
        testController.blockUser(53);

        //Unblocking a user who isn't blocked
        System.out.println("Attempting to unblock user ID = 99. This will fail (user not blocked)");
        temp = testController.unblockUser(99);
        if(temp)
            System.out.println("Unblocked user ID = 99. This is an error");
        else    
            System.out.println("User ID = 99 not blocked - can't unblock them (success)");
        //Unblocking a user
        System.out.println("Unblocking user ID = 24");
        temp = testController.unblockUser(24);
        if(temp)
            System.out.println("User ID = 24 unblocked successfully");
        else
            System.out.println("Failed to unblock user ID = 24");
        System.out.println("Remaining blocked users:");
        for(Integer i : testAcct.getBlacklist()){
            System.out.println("["+i+"]");
        }

        //Pinning a comment
        System.out.println("Pinning c2");
        temp = testController.pinComment(testCmt2);
        if(temp)
        {
            System.out.println("c2 pinned successfully\nPinned comments info:");
            for(FakeComment fc : testAcct.getPinned())
            {
                System.out.println("Title: "+fc.ctitle+"\nBody: "+fc.cbody);
            }
        }
        else
            System.out.println("Could not pin C2");

        //Adding some new comments
        FakeComment testCmt4 = new FakeComment(4, "this is a new comment", "<empty>");
        FakeComment testCmt5 = new FakeComment(5, "TITLE OF THE 5RST ONE!!1!", "gorp");
        testController.addComment(testCmt4);
        testController.addComment(testCmt5);
        //Removing comment
        System.out.println("Removing c1");
        temp = testController.removeComment(testCmt1);
        if(temp)
            System.out.println("c1 removed");
        else
            System.out.println("Failed to remove c1");
        //Removing pinned comment
        System.out.println("Removing c2, which is pinned");
        temp = testController.removeComment(testCmt2);
        if(temp)
            System.out.println("c2 removed");
        else
            System.out.println("Failed to remove c2");
        System.out.println("All remaining comments:");
        for(FakeComment fc : testAcct.getAllComments())
        {
            System.out.println("Title: "+fc.ctitle+"\nBody: "+fc.cbody);
        }
        System.out.println("Pinned comments:");
        for(FakeComment fc : testAcct.getPinned())
        {
            System.out.println("Title: "+fc.ctitle+"\nBody: "+fc.cbody);
        }
        System.out.println("(There should be no pinned comments left)");

        //Editing c4
        System.out.println("Editing c4\nOld Title: "+testCmt4.ctitle+"\nOld Body: "+testCmt4.cbody);
        temp = testController.editComment(testCmt4, "this is an edited comment", "I have edited this");
        if(temp)
        {
            System.out.println("Successfully edited c4");
        }
        else
            System.out.println("Didn't edit c4 (failed)");
        //Editing a comment not in the list anymore
        System.out.println("Attempting to edit c2 (not in the list anymore)");
        temp = testController.editComment(testCmt2, "hey there", "gorp 2");
        if(temp)
            System.out.println("Edited nonexistent comment (error)");
        else
            System.out.println(("Couldn't edit c2 - it was removed from the list earlier"));
        System.out.println("All comments after edits:");
        for(FakeComment fc : testAcct.getAllComments())
        {
            System.out.println("Title: "+fc.ctitle+"\nBody: "+fc.cbody);
        }

    }
    
    
}