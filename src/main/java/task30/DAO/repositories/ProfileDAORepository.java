package task30.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task30.entity.User;

public interface ProfileDAORepository extends JpaRepository<User, String> {

}
