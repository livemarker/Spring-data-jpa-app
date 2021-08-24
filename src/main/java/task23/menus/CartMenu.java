package task23.menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task23.entity.Product;
import task23.entity.User;
import task23.menus.intefaces.AccountMenuInterface;
import task23.menus.intefaces.CartMenuInterface;
import task23.menus.intefaces.MainMenuInterface;
import task23.menus.intefaces.OrderMenuInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CartMenu implements CartMenuInterface {

    private List<Product> cart = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private AccountMenuInterface accountMenuInterface;
    private OrderMenuInterface orderMenuInterface;


    @Override
    public void run(User user) throws SQLException {
        System.out.println("---------------------");
        System.out.println("Моя корзина");
        System.out.println(getCart().toString());
        System.out.println("");
        System.out.println("1.  Оплатить");
        System.out.println("2.  Очистить корзину");
        System.out.println("");
        System.out.println("Чтобы вернуться -1");

        int choice = sc.nextInt();
        if (choice == 1) {
            orderMenuInterface.addOrder(cart);
            orderMenuInterface.run(user);
            System.out.println("Товары оплачены, сформирован заказ");
        } else if (choice == 2) {
            clear();
            accountMenuInterface.run(user);
        } else if (choice == -1) {
            accountMenuInterface.run(user);
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
        cart.clear();
        System.out.println("Корзина с товарами отчищена");
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    @Autowired
    public void setAccountMenuInterface(AccountMenuInterface accountMenuInterface) {
        this.accountMenuInterface = accountMenuInterface;
    }

    @Autowired
    public void setOrderMenuInterface(OrderMenuInterface orderMenuInterface) {
        this.orderMenuInterface = orderMenuInterface;
    }
}
