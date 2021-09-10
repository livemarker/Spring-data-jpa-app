package task30.servises;

import java.sql.SQLException;

public interface ShopServiceInterface {
    void addToCart(int index) throws SQLException;

    void clearCart();
}
