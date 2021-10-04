package task30.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task30.DAO.interfaces.OrderDAOInterface;

import task30.DAO.repositories.CartDAORepository;
import task30.DAO.repositories.OrderDAORepository;

import task30.entity.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDAO implements OrderDAOInterface {

    private OrderDAORepository orderDAORepository;
    private CartDAORepository cartDAORepository;

    private final String statusNone = "не оплачено";
    private String newStatus = "Подготовка к отправке";

    public OrderDAO() {
    }

    public List<Order> getOrders(User user) {
        return orderDAORepository.getAllByLoginIs(user.getLogin());
    }

    @Transactional
    @Modifying
    public void addOrder(Order order) {
        orderDAORepository.save(order);
    }

    public void changeStatus(String login) {
        orderDAORepository.changeStatus(login, statusNone, newStatus);
    }

    public List<Cart> getUserCart(String login) {
        List<Order> temp = orderDAORepository.getAllByOrder_LoginAndOrder_Status(login, statusNone);
        if (temp.isEmpty()) {
            return new ArrayList<>();
        } else {
            return temp.get(0).getProducts();
        }

    }

    public List<Order> getCartOrder(String login) {
        return orderDAORepository.getAllByOrder_LoginAndOrder_Status(login, statusNone);

    }

    @Transactional
    public void delCart(String login) {
        List<Order> temp = orderDAORepository.getAllByOrder_LoginAndOrder_Status(login, statusNone);

        for (Order o : temp) {
            cartDAORepository.deleteCartByOrderIs(o);
        }
        orderDAORepository.delAllByOrder_LoginAndOrder_Status(login, statusNone);
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
