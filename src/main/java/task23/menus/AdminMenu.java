package task23.menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task23.DAO.interfaces.ShopDAOInterface;
import task23.entity.CategoryProducts;
import task23.entity.Product;
import task23.menus.intefaces.AdminMenuInterface;
import task23.menus.intefaces.MainMenuInterface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
public class AdminMenu implements AdminMenuInterface {
    private Scanner sc = new Scanner(System.in);
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private MainMenuInterface mainMenuInterface;
    private ShopDAOInterface shopDAOInterface;



    public void run() throws SQLException {
        System.out.println("------------------");
        System.out.println("Админ меню:");
        System.out.println("1.  Добавить товар");
        System.out.println("2.  Зайти как пользователь");
        int choice = sc.nextInt();

        if (choice == 1) {
            try {
                System.out.println("Добавление товара:");
                System.out.println("Укажите название:");
                String name = br.readLine();
                System.out.println("Укажите цену:");
                double price = sc.nextDouble();
                System.out.println("Укажите категорию:");
                String category = sc.next();

                CategoryProducts categoryProducts=new CategoryProducts(null,category);
                categoryProducts.setCategoryList(Collections.singletonList(new Product(null,name,price,categoryProducts)));

                shopDAOInterface.add(categoryProducts);
                System.out.println("Товар добавлен");
                run();
            } catch (Exception e) {
            }
        }
        if (choice == 2) {
            mainMenuInterface.run();
        }
    }
    @Autowired
    public void setMainMenuInterface(MainMenuInterface mainMenuInterface) {
        this.mainMenuInterface = mainMenuInterface;
    }
    @Autowired
    public void setShopDAOInterface(ShopDAOInterface shopDAOInterface) {
        this.shopDAOInterface = shopDAOInterface;
    }
}