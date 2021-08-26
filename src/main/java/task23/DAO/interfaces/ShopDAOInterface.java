package task23.DAO.interfaces;

import task23.entity.Cart;
import task23.entity.CategoryProducts;
import task23.entity.Order;
import task23.entity.Product;

import java.util.List;

public interface ShopDAOInterface {

    void add(CategoryProducts categoryProducts);

    List<CategoryProducts> getAllCategoryProducts();

    List<Product> getProducts(String category);

    List<CategoryProducts> getCategory (String category);


}
