package task23.DAO.interfaces;

import task23.entity.ListOrders;
import task23.entity.Product;
import task23.entity.User;
import task23.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAOInterface {
    public List<Order> getOrderList(User user) throws SQLException;
    void addOrder(ListOrders listOrders, Order order) throws SQLException;
}
