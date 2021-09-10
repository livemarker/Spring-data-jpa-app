package task30.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import task30.DAO.interfaces.OrderDAOInterface;
import task30.security.UserServiceInterface;

@Controller
public class CartController {
    private OrderDAOInterface orderDAOInterface;
    private UserServiceInterface userServiceInterface;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCart(Model model) {
        model.addAttribute("carts", orderDAOInterface.getUserCart(userServiceInterface.getSecurityLogin()));
        return "cart";
    }

    @Autowired
    public void setUserServiceInterface(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }
    @Autowired
    public void setOrderDAOInterface(OrderDAOInterface orderDAOInterface) {
        this.orderDAOInterface = orderDAOInterface;
    }
}
