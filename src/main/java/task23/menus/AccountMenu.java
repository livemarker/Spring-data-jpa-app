package task23.menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task23.DAO.interfaces.ProfileDAOInterface;
import task23.entity.User;
import task23.menus.intefaces.*;

import java.sql.SQLException;
import java.util.Scanner;

@Component
public class AccountMenu implements AccountMenuInterface {


    private MainMenuInterface mainMenuInterface;
    private AdminMenuInterface adminMenuInterface;
    private ShopMenuInterface shopMenuInterface;
    private CartMenuInterface cartMenuInterface;
    private OrderMenuInterface orderMenuInterface;
    private ProfileMenuInterface profileMenuInterface;

    private Scanner sc = new Scanner(System.in);
    private static User user;



    public void run(User user) throws SQLException {
        System.out.println("-------------------------");
        System.out.println("Добро пожаловать " + user.getFirstName() + " " + user.getLastName());
        System.out.println();
        System.out.println("Меню аккаунта ");
        System.out.println("1.  Магазин");
        System.out.println("2.  Информация о профиле");
        System.out.println("3.  Моя корзина");
        System.out.println("4.  Мои заказы");
        System.out.println("5.  Тех. поддержка");
        System.out.println("6.  Админка");
        System.out.println();
        System.out.println("Выход -1");
        int choice = sc.nextInt();
        if (choice == 1) {
            shopMenuInterface.run(user);
        } else if (choice == 2) {
            profileMenuInterface.run(user);
        } else if (choice == 3) {
            cartMenuInterface.run(user);
        } else if (choice == 4) {
            orderMenuInterface.run(user);
        } else if (choice == 5) {
            //  SupportMenu.create(user).run();
        } else if (choice == 6) {
            if (user.getLogin().equals("admin")) {
                adminMenuInterface.run();
            } else {
                System.out.println("Вы не являетесь администратором, выберите другой пункт меню");
                run(user);
            }
        } else if (choice == -1) {
            System.exit(1);
        } else {
            System.out.println("Выберите правильный пункт меню");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
            run(user);
        }
    }

    @Autowired
    public void setAdminMenuInterface(AdminMenuInterface adminMenuInterface) {
        this.adminMenuInterface = adminMenuInterface;
    }

    @Autowired
    public void setShopMenuInterface(ShopMenuInterface shopMenuInterface) {
        this.shopMenuInterface = shopMenuInterface;
    }

    @Autowired
    public void setCartMenuInterface(CartMenuInterface cartMenuInterface) {
        this.cartMenuInterface = cartMenuInterface;
    }

    @Autowired
    public void setOrderMenuInterface(OrderMenuInterface orderMenuInterface) {
        this.orderMenuInterface = orderMenuInterface;
    }

    @Autowired
    public void setProfileMenuInterface(ProfileMenuInterface profileMenuInterface) {
        this.profileMenuInterface = profileMenuInterface;
    }

    @Autowired
    public void setMainMenuInterface(MainMenuInterface mainMenuInterface) {
        this.mainMenuInterface = mainMenuInterface;
    }
}