package task23.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task23.entity.User;

public interface ProfileDAORepository extends JpaRepository<User, String> {

}
