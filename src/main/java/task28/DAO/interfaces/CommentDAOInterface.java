package task28.DAO.interfaces;

import task28.entity.Comment;

import java.util.List;

public interface CommentDAOInterface {
    Comment getComments(int id);
    List<Comment> getAllByProductIdIs(int id);
}
