package task23.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import task23.entity.User;

public interface UserRepository  extends JpaRepository<User,String> {
}
