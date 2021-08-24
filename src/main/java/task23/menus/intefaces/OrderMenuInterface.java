package task23.menus.intefaces;

import task23.entity.Product;
import task23.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface OrderMenuInterface {
    void run(User user) throws SQLException;
    void addOrder(List<Product> products);
}
