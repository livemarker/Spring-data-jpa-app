package task23.DAO.interfaces;

import org.springframework.data.jpa.repository.Query;
import task23.entity.CategoryProducts;
import task23.entity.Product;

import java.util.List;

public interface ShopDAOInterface {
    void add(CategoryProducts categoryProducts);
    List<CategoryProducts> getCategoryProducts();
    List<Product> getProducts(String category);


}
