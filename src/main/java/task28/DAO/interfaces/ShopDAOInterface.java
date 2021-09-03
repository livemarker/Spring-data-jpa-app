package task28.DAO.interfaces;

import task28.entity.CategoryProducts;
import task28.entity.Product;

import java.util.List;

public interface ShopDAOInterface {

    void add(CategoryProducts categoryProducts);

    List<CategoryProducts> getAllCategoryProducts();

    List<Product> getProducts(String category);

    List<CategoryProducts> getCategory (String category);


}
