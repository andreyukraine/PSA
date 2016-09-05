package ua.artcode.controler;

import ua.artcode.model.Comment;
import ua.artcode.model.Company;
import ua.artcode.model.Service;
import ua.artcode.model.Worker;

import java.util.List;

/**
 * Created by IT on 04.09.2016.
 */
public interface IComments {




    //client
    //оставить комментарий сервису
    Comment addCommentService (Service service);
    //оставить комментарий компании
    Comment addCommentCompany (Company company);
    //оставить комментарий сотруднику
    Comment addCommentWorker (Worker worker);
    //оставить комментарий про систему
    Comment addCommentPSA();

    //moderator PSA
    //ответить на коментарий сервиса PSA
    Comment replyToComment(long commentID, Comment comment);
    //удалить комментарий сервиса PSA
    Comment removeComment(long commentID);
    //посмотреть комментарии сервиса PSA
    List<Comment> listAllComment();








}
