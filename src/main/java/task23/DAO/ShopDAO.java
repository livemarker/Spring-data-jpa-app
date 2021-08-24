package task23.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task23.DAO.interfaces.ShopDAOInterface;
import task23.DAO.repositories.ShopDAOCategoryRepository;
import task23.entity.CategoryProducts;
import task23.entity.Product;
import task23.DAO.repositories.ShopDAOProductRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopDAO implements ShopDAOInterface {

    private ShopDAOProductRepository shopDAOProductRepository;

    private ShopDAOCategoryRepository shopDAOCategoryRepository;

    @Autowired
    public ShopDAO(ShopDAOProductRepository shopDAOProductRepository,
                   ShopDAOCategoryRepository shopDAOCategoryRepository) {

        this.shopDAOProductRepository = shopDAOProductRepository;
        this.shopDAOCategoryRepository = shopDAOCategoryRepository;
    }

    @Override
    public void add(CategoryProducts categoryProducts) {
        shopDAOCategoryRepository.save(categoryProducts);
    }

    @Override
    public List<CategoryProducts> getCategoryProducts() {
        return shopDAOCategoryRepository.findAll();
    }

    @Override
    public List<Product> getProducts(int index) {
        CategoryProducts categoryProducts = shopDAOCategoryRepository.getOne(index);
        return categoryProducts.getCategories();
    }
}
