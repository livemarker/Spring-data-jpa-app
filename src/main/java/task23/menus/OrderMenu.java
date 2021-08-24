package task23.menus;

import org.springframework.stereotype.Service;
import task23.DAO.interfaces.OrderDAOInterface;
import task23.entity.ListOrders;
import task23.entity.Product;
import task23.entity.User;
import task23.menus.intefaces.AccountMenuInterface;
import task23.menus.intefaces.MainMenuInterface;
import task23.menus.intefaces.OrderMenuInterface;
import task23.entity.Order;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@Service
public class OrderMenu implements OrderMenuInterface {

    private AccountMenuInterface accountMenuInterface;
    private OrderDAOInterface orderDAOInterface;
    private MainMenuInterface mainMenuInterface;
    private Scanner sc = new Scanner(System.in);
    private User user;


    @Override
    public void run() throws SQLException {
        System.out.println("----------------");
        System.out.println("Меню заказов");
        getOrder();
        System.out.println();
        System.out.println("Для возврата в меню аккаунта: -1");
        int choice = sc.nextInt();
        if (choice == -1) {
            accountMenuInterface.run();
        } else {
            run();
        }
    }

    private void getOrder() throws SQLException {
        List<Order> list = orderDAOInterface.getOrderList(user);
        int delitel = 1;
        for (int i = 0; i < list.size(); i++) {
            if (delitel != list.get(i).getOrderNumber()) {
                System.out.println();
            }
            System.out.print(list.get(i).toString());
            delitel = list.get(i).getOrderNumber();
        }
    }

    @Override
    public void addOrder(List<Product> products) {
        //new ListOrders(null,user.getLogin(),)
       // new Order(null,products,"Подготовка к отправке");
        //orderDAOInterface.addOrder(user, products);
    }

    public void setAccountMenuInterface(AccountMenuInterface accountMenuInterface) {
        this.accountMenuInterface = accountMenuInterface;
    }

    public void setOrderDAOInterface(OrderDAOInterface orderDAOInterface) {
        this.orderDAOInterface = orderDAOInterface;
    }

    public void setMainMenuInterface(MainMenuInterface mainMenuInterface) {
        this.mainMenuInterface = mainMenuInterface;
    }
}