package task29.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task29.entity.User;

import java.util.List;

public interface ProfileDAORepository extends JpaRepository<User, String> {
    List<User> getAllByLoginNotNull ();
}
