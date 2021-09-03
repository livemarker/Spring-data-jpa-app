package task28.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import task28.DAO.interfaces.OrderDAOInterface;
import task28.entity.User;

import java.sql.SQLException;

@Controller
public class OrderController {
    private OrderDAOInterface orderDAOInterface;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String getCart(Model model) throws SQLException {
        model.addAttribute("orders", orderDAOInterface.getOrders(new User("Никита")));
        return "order";
    }

    @Autowired
    public void setOrderDAOInterface(OrderDAOInterface orderDAOInterface) {
        this.orderDAOInterface = orderDAOInterface;
    }
}
