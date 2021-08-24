package task23.menus.intefaces;

import task23.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface OrderMenuInterface {
    void run() throws SQLException;
    void addOrder(List<Product> products);
}
