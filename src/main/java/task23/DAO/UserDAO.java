package task23.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task23.DAO.interfaces.UserDAOInterface;
import task23.entity.User;
import task23.DAO.repositories.UserRepository;

import java.sql.*;

@Component
public class UserDAO implements UserDAOInterface {

    private UserRepository userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository) throws SQLException {
        this.userRepository = userRepository;

    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User load(String user) {
        return userRepository.getByLogin(user);
    }

}
