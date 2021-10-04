package task30.DAO.interfaces;

import task30.entity.Comment;

import java.util.List;

public interface CommentDAOInterface {
    Comment getComments(int id);
    List<Comment> getAllByProductIdIs(int id);
}
