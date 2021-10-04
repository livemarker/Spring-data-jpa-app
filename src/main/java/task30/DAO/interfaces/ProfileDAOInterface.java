package task30.DAO.interfaces;

import task30.entity.User;

import java.sql.SQLException;

public interface ProfileDAOInterface {

    void changeInfo(User user) throws SQLException;

    void delProfile(User user) throws SQLException;
}
