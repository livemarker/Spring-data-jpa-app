package task23.menus.intefaces;

import task23.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface CartMenuInterface {
    void run() throws SQLException;
    List<Product> getCart();
}
