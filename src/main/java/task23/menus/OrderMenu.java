package task23.menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task23.DAO.interfaces.OrderDAOInterface;

import task23.entity.User;
import task23.menus.intefaces.OrderMenuInterface;
import task23.entity.Order;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@Service
public class OrderMenu implements OrderMenuInterface {

    private OrderDAOInterface orderDAOInterface;
    private Scanner sc = new Scanner(System.in);
    private User user;

    @Override
    public void run(User user) throws SQLException {
        this.user = user;
        System.out.println("----------------");
        System.out.println("Меню заказов");
        getOrders();
        System.out.println();
        System.out.println("Для возврата в меню аккаунта: -1");
        int choice = sc.nextInt();
        if (choice == -1) {

        } else {
            run(user);
        }
    }

    private void getOrders() throws SQLException {
        List<Order> list = orderDAOInterface.getOrders(user);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("id = " + list.get(i).getId() +
                    ", login = " + list.get(i).getLogin() +
                    ", status = " + list.get(i).getStatus() +
                    ", nameProduct = " + list.get(i).getProducts().get(0).getName() +
                    ", price = " + list.get(i).getProducts().get(0).getPrice());
        }
    }

    @Override
    public void buy(User user) {
        orderDAOInterface.changeStatus(user.getLogin());
    }

    @Autowired
    public void setOrderDAOInterface(OrderDAOInterface orderDAOInterface) {
        this.orderDAOInterface = orderDAOInterface;
    }
}