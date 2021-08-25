package task23.menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task23.DAO.interfaces.OrderDAOInterface;
import task23.DAO.interfaces.ShopDAOInterface;
import task23.entity.*;
import task23.menus.intefaces.CartMenuInterface;
import task23.menus.intefaces.ShopMenuInterface;

import java.sql.SQLException;
import java.util.*;

@Service
public class ShopMenu implements ShopMenuInterface {
    private Scanner sc = new Scanner(System.in);
    private List<Product> listProductsTemp = new ArrayList<>();
    private ShopDAOInterface shopDAOInterface;
    private CartMenuInterface cartMenuInterface;
    private OrderDAOInterface orderDAOInterface;
    private User user;


    public void run(User user) throws SQLException {
        this.user = user;
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
        List<String> strings = new ArrayList<>(category);

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(i + ".     " + strings.get(i));
        }
        System.out.println();
        System.out.println("Для перехода назад цифра -1");
        int choice = sc.nextInt();

        if (choice == -1) {

        } else {
            String choiceCategory = strings.get(choice);
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

    private void addToCart(int index) throws SQLException {
        String status = "не оплачено";

        Cart cart;
        Order order = new Order(0, user.getLogin(), status);
        order.setProducts(
                Collections.singletonList(
                        cart = new Cart(
                                null,
                                listProductsTemp.get(index - 1).getName(),
                                listProductsTemp.get(index - 1).getPrice(),
                                order)));

        cartMenuInterface.getCart(user).add(cart);
        orderDAOInterface.addOrder(order);

        System.out.println(listProductsTemp.get(index - 1).toString() + " добавлен в корзину");
        System.out.println();
    }

    @Autowired
    public void setOrderDAOInterface(OrderDAOInterface orderDAOInterface) {
        this.orderDAOInterface = orderDAOInterface;
    }

    @Autowired
    public void setShopDAOInterface(ShopDAOInterface shopDAOInterface) {
        this.shopDAOInterface = shopDAOInterface;
    }

    @Autowired
    public void setCartMenuInterface(CartMenuInterface cartMenuInterface) {
        this.cartMenuInterface = cartMenuInterface;
    }
}