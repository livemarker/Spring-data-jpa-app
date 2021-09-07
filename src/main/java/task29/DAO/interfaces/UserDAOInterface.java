package task29.DAO.interfaces;

import task29.entity.User;

public interface UserDAOInterface {
    User save(User user);
    User load(String user);

}
