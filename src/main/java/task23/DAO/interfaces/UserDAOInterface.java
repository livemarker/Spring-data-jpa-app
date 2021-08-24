package task23.DAO.interfaces;

import org.springframework.stereotype.Repository;
import task23.entity.User;




public interface UserDAOInterface {
    User save(User user);
    User load(String user);

}
