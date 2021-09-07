package task29.DAO.interfaces;

import task29.entity.CategoryProducts;
import task29.entity.Product;

import java.util.List;

public interface ShopDAOInterface {

    void add(CategoryProducts categoryProducts);

    List<CategoryProducts> getAllCategoryProducts();

    List<Product> getProducts(String category);

    List<CategoryProducts> getCategory(String category);

    Product getOneProduct(int id);

    void delOneProduct(int id);

    void updateOneProduct(Product product);

}
