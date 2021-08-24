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
import java.util.*;

@Service
public class ShopMenu implements ShopMenuInterface {
    private Scanner sc = new Scanner(System.in);
    private List<Product> listProductsTemp = new ArrayList<>();
    private AccountMenuInterface accountMenuInterface;
    private ShopDAOInterface shopDAOInterface;
    private CartMenuInterface cartMenuInterface;
    private User user;

    @Autowired
    public ShopMenu(AccountMenuInterface accountMenuInterface,
                    ShopDAOInterface shopDAOInterface,
                    CartMenuInterface cartMenuInterface) {

        this.accountMenuInterface = accountMenuInterface;
        this.shopDAOInterface = shopDAOInterface;
        this.cartMenuInterface = cartMenuInterface;
    }

    public void run(User user) throws SQLException {
        this.user=user;
        System.out.println("-------------------");
        System.out.println("Меню товаров:");
        showCategoryProducts();
        System.out.println();
    }

    private void showCategoryProducts() throws SQLException {

        System.out.println("Выберите категорию товаров по номеру:");
        Set<String> category = new HashSet<>();
        List<CategoryProducts> listCategory = shopDAOInterface.getCategoryProducts();
        for (int i = 0; i < listCategory.size(); i++) {
            category.add(listCategory.get(i).getCategories());
        }
        for (int i = 0; i < category.size(); i++) {
            System.out.println(i + ".     " + category.iterator().next());
        }
        System.out.println();
        System.out.println("Для перехода назад цифра -1");
        int choice = sc.nextInt();
        String choiceCategory="";
        for (int i = 0; i < category.size(); i++) {
            if (i==choice){
                choiceCategory=category.iterator().next();
                break;
            }
            category.iterator().next();
        }
        if (choice == -1) {
            accountMenuInterface.run(user);
        } else {
            getProducts(choiceCategory);
        }
    }

    private void getProducts(String choiceCategory) throws SQLException {
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