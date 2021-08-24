package task23.DAO.interfaces;

import task23.entity.CategoryProducts;
import task23.entity.Product;

import java.util.List;

public interface ShopDAOInterface {
    void add(CategoryProducts categoryProducts);
    List<CategoryProducts> getCategoryProducts();
    List<Product> getProducts(int index);
}
