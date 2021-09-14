package task30.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import task30.DAO.interfaces.OrderDAOInterface;
import task30.entity.User;
import task30.security.UserServiceInterface;

import java.sql.SQLException;

@Controller
public class OrderController {
    private OrderDAOInterface orderDAOInterface;
    private UserServiceInterface userServiceInterface;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String getOrders(Model model) throws SQLException {
        model.addAttribute("orders", orderDAOInterface.getOrders(new User(userServiceInterface.getSecurityLogin())));
        return "order";
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
