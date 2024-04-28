public abstract class LNFileCRUDOps {
    public abstract boolean createNotesFile(String name,LNFolder folder,LNAccount account);
    public abstract boolean deleteNotesFile(LNFile deleted);
    public abstract LNFile getNotesFile(int id);
    public abstract boolean updateNotesFile(int NotesFileID,String name,String folder);
}
