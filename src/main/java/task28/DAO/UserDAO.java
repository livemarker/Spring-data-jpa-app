package task28.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task28.DAO.interfaces.UserDAOInterface;
import task28.entity.User;
import task28.DAO.repositories.UserDAORepository;

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
