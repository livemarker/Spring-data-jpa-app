package task23.menus.intefaces;

import task23.entity.Cart;
import task23.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface CartMenuInterface {

    void run(User user) throws SQLException;

    List<Cart> getCart(User user);
}
