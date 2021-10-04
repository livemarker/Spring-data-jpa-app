package task30.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import task30.DAO.interfaces.OrderDAOInterface;
import task30.security.UserServiceInterface;
import task30.servises.ShopServiceInterface;

@Controller
public class CartController {
    private OrderDAOInterface orderDAOInterface;
    private UserServiceInterface userServiceInterface;
    private ShopServiceInterface shopServiceInterface;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCart(Model model) {
        model.addAttribute("carts", orderDAOInterface.getUserCart(userServiceInterface.getSecurityLogin()));
        return "cart";
    }

    @PostMapping(value = "/cart")
    public String clearCart(Model model) {
        shopServiceInterface.clearCart();
        return getCart(model);
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
    public void setShopServiceInterface(ShopServiceInterface shopServiceInterface) {
        this.shopServiceInterface = shopServiceInterface;
    }
}
