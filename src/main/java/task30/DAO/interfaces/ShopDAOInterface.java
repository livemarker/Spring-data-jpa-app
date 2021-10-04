package task30.DAO.interfaces;

import task30.entity.CategoryProducts;
import task30.entity.Product;

import java.util.List;

public interface ShopDAOInterface {

    void add(CategoryProducts categoryProducts);

    List<CategoryProducts> getAllCategoryProducts();

    List<Product> getProducts(String category);

    List<CategoryProducts> getCategory(String category);

    Product getOneProduct(int id);



}
