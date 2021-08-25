package task23.menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task23.DAO.interfaces.OrderDAOInterface;
import task23.entity.Cart;

import task23.entity.User;
import task23.menus.intefaces.CartMenuInterface;
import task23.menus.intefaces.OrderMenuInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CartMenu implements CartMenuInterface {
    private User user;
    private List<Cart> cart = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private OrderMenuInterface orderMenuInterface;
    private OrderDAOInterface orderDAOInterface;

    @Override
    public void run(User user) throws SQLException {
        this.user = user;
        System.out.println("---------------------");
        System.out.println("Моя корзина");

        showCart(getCart(user));

        System.out.println("");
        System.out.println("1.  Оплатить");
        System.out.println("2.  Очистить корзину");
        System.out.println("");
        System.out.println("Чтобы вернуться -1");

        int choice = sc.nextInt();
        if (choice == 1) {
            orderMenuInterface.buy(user);
            cart.clear();
            orderMenuInterface.run(user);
            System.out.println("Товары оплачены, сформирован заказ");
        } else if (choice == 2) {
            clear();

        } else if (choice == -1) {

        } else {
            System.out.println("Выберите правильный пункт меню");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
            run(user);
        }
    }

    private void clear() {
        if (!cart.isEmpty()) {
            orderDAOInterface.delCart(user.getLogin());
            cart.clear();
        }
        System.out.println("Корзина с товарами отчищена");
    }

    public List<Cart> getCart(User user) {
        if (cart.isEmpty()) {
            cart = orderDAOInterface.getUserCart(user.getLogin());
        }
        return cart;
    }

    private void showCart(List<Cart> cart) {
        if (!cart.isEmpty()) {
            for (Cart c : cart) {
                System.out.println("Product =" + c.getName() +
                        ", price = " + c.getPrice() +
                        ", login = " + c.getOrder().getLogin() +
                        ", status = " + c.getOrder().getStatus());
            }
        } else System.out.println("Корзина пуста");
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    @Autowired
    public void setOrderMenuInterface(OrderMenuInterface orderMenuInterface) {
        this.orderMenuInterface = orderMenuInterface;
    }

    @Autowired
    public void setOrderDAOInterface(OrderDAOInterface orderDAOInterface) {
        this.orderDAOInterface = orderDAOInterface;
    }
}
