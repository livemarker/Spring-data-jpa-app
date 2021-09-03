package task28.DAO.interfaces;

import task28.entity.User;

public interface UserDAOInterface {
    User save(User user);
    User load(String user);

}
