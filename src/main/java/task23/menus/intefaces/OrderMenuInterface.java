package task23.menus.intefaces;

import task23.entity.User;

import java.sql.SQLException;

public interface OrderMenuInterface {

    void run(User user) throws SQLException;

    void buy(User user);
}
