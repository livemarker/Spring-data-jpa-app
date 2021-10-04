package task30.DAO.interfaces;

import task30.entity.User;

public interface UserDAOInterface {
    User save(User user);
    User load(String user);

}
