package task23.DAO.interfaces;

import task23.entity.User;

import java.sql.SQLException;

public interface ProfileDAOInterface {

    void changeInfo(User user) throws SQLException;

    void delProfile(User user) throws SQLException;
}
