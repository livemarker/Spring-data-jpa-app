package task28.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task28.entity.User;

public interface ProfileDAORepository extends JpaRepository<User, String> {

}
