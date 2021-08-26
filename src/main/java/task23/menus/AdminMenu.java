package task23.menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task23.DAO.interfaces.ShopDAOInterface;
import task23.entity.CategoryProducts;
import task23.entity.Product;
import task23.menus.intefaces.AdminMenuInterface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
public class AdminMenu implements AdminMenuInterface {
    private Scanner sc = new Scanner(System.in);
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private ShopDAOInterface shopDAOInterface;


    public void run() {
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
                String category = br.readLine();


                CategoryProducts categoryProducts = getCategory(category);

                categoryProducts.setCategoryList(addProduct(category,new Product(null, name, price, categoryProducts)));

                shopDAOInterface.add(categoryProducts);
                System.out.println("Товар добавлен");
                run();
            } catch (Exception ignored) {
            }
        } else if (choice == 2) {

        } else {
            run();
        }
    }

    private CategoryProducts getCategory(String category) {
        CategoryProducts categoryProducts;
        List<CategoryProducts> categories = shopDAOInterface.getCategory(category);
        if (!categories.isEmpty()) {
            categoryProducts = categories.get(0);
        } else {
            categoryProducts = new CategoryProducts(null, category);
        }
        return categoryProducts;
    }
    private List<Product> addProduct(String category,Product product){
        List<Product> products=shopDAOInterface.getProducts(category);
        if (!products.isEmpty()) {
            products.add(product);
        } else {
            products=new ArrayList<>();
            products.add(product);
        }
        return products;

    }

    @Autowired
    public void setShopDAOInterface(ShopDAOInterface shopDAOInterface) {
        this.shopDAOInterface = shopDAOInterface;
    }
}