package task30.DAO.interfaces;

import task30.entity.Cart;
import task30.entity.User;
import task30.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAOInterface {

    List<Order> getOrders(User user) throws SQLException;

    void addOrder(Order order) throws SQLException;

    void changeStatus(String login);

    List<Cart> getUserCart(String login);

    void delCart(String login);

}
