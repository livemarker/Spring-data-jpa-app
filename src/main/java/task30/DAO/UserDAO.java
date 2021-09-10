package task30.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task30.DAO.interfaces.UserDAOInterface;
import task30.entity.User;
import task30.DAO.repositories.UserDAORepository;

@Component
public class UserDAO implements UserDAOInterface {

    private UserDAORepository userDAORepository;

    @Autowired
    public UserDAO(UserDAORepository userDAORepository) {
        this.userDAORepository = userDAORepository;
    }

    @Override
    public User save(User user) {
        return userDAORepository.save(user);
    }

    @Override
    public User load(String user) {
        return userDAORepository.getByLogin(user);
    }

}
