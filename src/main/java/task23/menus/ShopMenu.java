package task23.menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task23.DAO.interfaces.ShopDAOInterface;
import task23.entity.CategoryProducts;
import task23.entity.Product;
import task23.entity.User;
import task23.menus.intefaces.AccountMenuInterface;
import task23.menus.intefaces.CartMenuInterface;
import task23.menus.intefaces.ShopMenuInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ShopMenu implements ShopMenuInterface {
    private User user;
    private Scanner sc = new Scanner(System.in);
    private List<Product> listProductsTemp = new ArrayList<>();
    private AccountMenuInterface accountMenuInterface;
    private ShopDAOInterface shopDAOInterface;
    private CartMenuInterface cartMenuInterface;

    @Autowired
    public ShopMenu(User user, AccountMenuInterface accountMenuInterface,
                    ShopDAOInterface shopDAOInterface,
                    CartMenuInterface cartMenuInterface) {
        this.user = user;
        this.accountMenuInterface = accountMenuInterface;
        this.shopDAOInterface = shopDAOInterface;
        this.cartMenuInterface = cartMenuInterface;
    }

    public void run() throws SQLException {
        System.out.println("-------------------");
        System.out.println("Меню товаров:");
        showCategoryProducts();
        System.out.println();
    }

    private void showCategoryProducts() throws SQLException {
        System.out.println("Выберите категорию товаров по номеру:");
        List<CategoryProducts> listCategory = shopDAOInterface.getCategoryProducts();
        for (int i = 0; i < listCategory.size(); i++) {
            System.out.println(listCategory.get(i).getId() + ".    " + listCategory.get(i).getCategories());
        }
        System.out.println();
        System.out.println("Для перехода назад цифра -1");

        int choice = sc.nextInt();
        if (choice == -1) {
            accountMenuInterface.run();
        } else {
            getProducts(choice);
        }
    }

    private void getProducts(int choiceCategory) throws SQLException {
        System.out.println("Выберите товар по номеру, чтобы добавить в корзину:");

        listProductsTemp = shopDAOInterface.getProducts(choiceCategory);
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

    private void addToCart(int index) {

        cartMenuInterface.getCart().add(listProductsTemp.get(index - 1));
        System.out.println(listProductsTemp.get(index - 1).toString() + " добавлен в корзину");
        System.out.println();
    }
}