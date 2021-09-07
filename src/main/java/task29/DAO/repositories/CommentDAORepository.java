package task29.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task29.entity.Comment;

import java.util.List;

public interface CommentDAORepository extends JpaRepository<Comment, Integer> {
    List<Comment> getAllByProductIdIs(int id);
}
