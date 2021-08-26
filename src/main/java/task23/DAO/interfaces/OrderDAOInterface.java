package task23.DAO.interfaces;

import task23.entity.Cart;
import task23.entity.User;
import task23.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAOInterface {

    List<Order> getOrders(User user) throws SQLException;

    void addOrder(Order order) throws SQLException;

    void changeStatus(String login);

    List<Cart> getUserCart(String login);

    void delCart(String login);

}
