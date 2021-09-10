package task30.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task30.entity.User;

@Repository
public interface UserDAORepository extends JpaRepository<User, String> {

    User getByLogin(String id);
}
