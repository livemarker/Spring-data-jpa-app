package task23.DAO;

import task23.entity.Order;
import task23.entity.Product;
import task23.entity.User;

import java.util.List;

public interface OrderDAOInterface {
    List<Order> getOrderList(User user);

    void addOrder(User user, List<Product> products);
}
