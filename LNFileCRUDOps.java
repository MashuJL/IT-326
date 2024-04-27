public abstract class LNFileCRUDOps {
    public abstract boolean createNotesFile(String name,LNFolder folder);
    public abstract boolean deleteNotesFile();
    public abstract LNFile getNotesFile();
    public abstract boolean updateNotesFile(int NotesFileID,String name,String folder);
}
