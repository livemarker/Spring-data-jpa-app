package task29.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import task29.DAO.interfaces.OrderDAOInterface;
import task29.entity.Order;
import task29.entity.User;

import java.sql.SQLException;
import java.util.List;

@RestController
public class OrderController {
    private OrderDAOInterface orderDAOInterface;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Order> getOrders(@RequestParam String login) throws SQLException {
        return orderDAOInterface.getOrders(new User(login));
    }

    @Autowired
    public void setOrderDAOInterface(OrderDAOInterface orderDAOInterface) {
        this.orderDAOInterface = orderDAOInterface;
    }
}
