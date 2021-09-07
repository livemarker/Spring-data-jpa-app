package task29.DAO.interfaces;

import task29.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface ProfileDAOInterface {

    void delProfile(String login) throws SQLException;

    List<User> getAllUsers();
}
