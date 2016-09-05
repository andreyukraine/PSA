package ua.artcode.controler;

import ua.artcode.db.AppDBImpl;
import ua.artcode.model.Comment;
import ua.artcode.model.Company;
import ua.artcode.model.Service;
import ua.artcode.model.Worker;
import ua.artcode.utils.DBFileHandler;

import java.util.List;

/**
 * Created by IT on 04.09.2016.
 */
public class CommentsImp implements IComments {

    private AppDBImpl appDB;
    private DBFileHandler dbFileHandler;

    public CommentsImp() {
    }

    public CommentsImp(AppDBImpl appDB, DBFileHandler dbFileHandler) {
        this.appDB = appDB;
        this.dbFileHandler = dbFileHandler;
    }

    @Override
    public Comment addCommentService(Service service) {
        return null;
    }

    @Override
    public Comment addCommentCompany(Company company) {
        return null;
    }

    @Override
    public Comment addCommentWorker(Worker worker) {
        return null;
    }

    @Override
    public Comment addCommentPSA() {
        return null;
    }

    @Override
    public Comment replyToComment(long commentID, Comment comment) {
        return null;
    }

    @Override
    public Comment removeComment(long commentID) {
        return null;
    }

    @Override
    public List<Comment> listAllComment() {
        return null;
    }
}
