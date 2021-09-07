package task29.DAO.interfaces;

import task29.entity.Comment;

import java.util.List;

public interface CommentDAOInterface {
    Comment getComments(int id);
    List<Comment> getAllByProductIdIs(int id);
}
