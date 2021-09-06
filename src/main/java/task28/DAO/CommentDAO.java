package task28.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task28.DAO.interfaces.CommentDAOInterface;
import task28.DAO.repositories.CommentDAORepository;
import task28.entity.Comment;
import task28.entity.Product;

import java.util.List;

@Service
public class CommentDAO implements CommentDAOInterface {

    private CommentDAORepository commentDAORepository;

    public Comment getComments(int id) {
        return commentDAORepository.getOne(id);
    }

    public List<Comment> getAllByProductIdIs(int id){
        return commentDAORepository.getAllByProductIdIs(id);
    }


    @Autowired
    public void setCommentDAORepository(CommentDAORepository commentDAORepository) {
        this.commentDAORepository = commentDAORepository;
    }
}
