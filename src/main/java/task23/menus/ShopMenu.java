package task23.menus;

import task23.DAO.ShopDAO;
import task23.entity.Product;
import task23.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopMenu {
    private User user;
    private Scanner sc = new Scanner(System.in);
    private List<Product> listProductsTemp = new ArrayList<>();

    public ShopMenu(User user) {
        this.user = user;
    }

    public void run() throws SQLException {
        System.out.println("-------------------");
        System.out.println("Меню товаров:");
        System.out.println("Выберите категорию товаров по номеру:");
        showCategoryProducts();
        System.out.println("Выберите товар по номеру, чтобы добавить в корзину:");
        System.out.println();
    }

    private void showCategoryProducts() throws SQLException {

        List<String> listCategory = ShopDAO.create().getCategoryProducts();
        for (int i = 0; i < listCategory.size(); i++) {
            System.out.println(i + 1 + ".    " + listCategory.get(i));
        }
        System.out.println();
        System.out.println("Для перехода назад цифра -1");

        int choice = sc.nextInt();
        if (choice == -1) {
            AccountMenu.create(user).run();
        } else {
            getProducts(choice);
        }
    }

    private void getProducts(int choiceCategory) throws SQLException {

        listProductsTemp = ShopDAO.create().getProducts(choiceCategory);
        for (int i = 0; i < listProductsTemp.size(); i++) {
            System.out.println(i + 1 + ".    " + listProductsTemp.get(i));
        }
        System.out.println();
        System.out.println("Для перехода назад цифра -1");

        int choice = sc.nextInt();
        if (choice == -1) {
            showCategoryProducts();
        } else {
            addToCart(choice);
            getProducts(choiceCategory);
        }
    }

    private void addToCart(int index) throws SQLException {

        CartMenu.create(user).getCart().add(listProductsTemp.get(index - 1));
        System.out.println(listProductsTemp.get(index - 1).toString() + " добавлен в корзину");
        System.out.println();
    }
}
