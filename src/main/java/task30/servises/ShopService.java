package task30.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import task30.DAO.interfaces.OrderDAOInterface;
import task30.DAO.interfaces.ShopDAOInterface;
import task30.entity.Cart;
import task30.entity.Order;
import task30.entity.Product;
import task30.security.UserServiceInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService implements ShopServiceInterface {
    private UserServiceInterface userServiceInterface;
    private OrderDAOInterface orderDAOInterface;
    private ShopDAOInterface shopDAOInterface;


    public void addToCart(int index) throws SQLException {
        String status = "не оплачено";
        String login = userServiceInterface.getSecurityLogin();

        Product product = shopDAOInterface.getOneProduct(index);
        Order orderNew;
        List<Cart> cart;
        List<Order> tempList = orderDAOInterface.getCartOrder(login);

        if (!tempList.isEmpty()) {
            orderNew = orderDAOInterface.getCartOrder(login).get(0);
            cart = orderDAOInterface.getUserCart(login);

        } else {
            orderNew = new Order(0, login, status, null);
            cart = new ArrayList<>();
        }
        cart.add(new Cart(0, product.getName(), product.getPrice(), orderNew));
        orderNew.setProducts(cart);
        orderDAOInterface.addOrder(orderNew);
    }

    public void clearCart() {
        String login = userServiceInterface.getSecurityLogin();
        orderDAOInterface.delCart(login);
    }

    @Autowired
    public void setUserServiceInterface(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @Autowired
    public void setOrderDAOInterface(OrderDAOInterface orderDAOInterface) {
        this.orderDAOInterface = orderDAOInterface;
    }

    @Autowired
    public void setShopDAOInterface(ShopDAOInterface shopDAOInterface) {
        this.shopDAOInterface = shopDAOInterface;
    }


}
