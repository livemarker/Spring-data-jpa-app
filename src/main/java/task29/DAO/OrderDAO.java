package task29.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task29.DAO.interfaces.OrderDAOInterface;

import task29.DAO.repositories.CartDAORepository;
import task29.DAO.repositories.OrderDAORepository;

import task29.entity.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDAO implements OrderDAOInterface {

    private OrderDAORepository orderDAORepository;
    private CartDAORepository cartDAORepository;

    private String status = "не оплачено";
    private String newStatus = "Подготовка к отправке";

    public OrderDAO() {
    }

    public List<Order> getOrders(User user) {
        return orderDAORepository.getAllByLoginIs(user.getLogin());
    }

    public void addOrder(Order order) {
        orderDAORepository.save(order);
    }

    public void changeStatus(String login) {
        orderDAORepository.changeStatus(login, status, newStatus);
    }

    public List<Cart> getUserCart(String login) {
        List<Order> temp = orderDAORepository.getAllByOrder_LoginAndOrder_Status(login, status);

        List<Cart> userCart = new ArrayList<>();
        for (Order order : temp) {
            userCart.add(order.getProducts().get(0));
        }
        return userCart;
    }

    @Transactional
    public void delCart(String login) {
        List<Order> temp = orderDAORepository.getAllByOrder_LoginAndOrder_Status(login, status);

        for (Order o : temp) {
            cartDAORepository.deleteCartByOrderIs(o);
        }
        orderDAORepository.delAllByOrder_LoginAndOrder_Status(login, status);
    }

    public Cart getCartByID(int id) {
        return cartDAORepository.getById(id);
    }

    @Autowired
    public void setOrderDAORepository(OrderDAORepository orderDAORepository) {
        this.orderDAORepository = orderDAORepository;
    }

    @Autowired
    public void setCartDAORepository(CartDAORepository cartDAORepository) {
        this.cartDAORepository = cartDAORepository;
    }
}
