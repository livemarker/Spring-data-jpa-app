package task28.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import task28.DAO.interfaces.OrderDAOInterface;

@Controller
public class CartController {
    private OrderDAOInterface orderDAOInterface;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCart(Model model) {
        model.addAttribute("carts", orderDAOInterface.getUserCart("Никита"));
        return "cart";
    }


    @Autowired
    public void setOrderDAOInterface(OrderDAOInterface orderDAOInterface) {
        this.orderDAOInterface = orderDAOInterface;
    }
}
