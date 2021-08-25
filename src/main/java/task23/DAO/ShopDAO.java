package task23.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task23.DAO.interfaces.ShopDAOInterface;
import task23.DAO.repositories.shopDAO.ShopDAOCategoryRepository;
import task23.entity.CategoryProducts;
import task23.entity.Product;
import task23.DAO.repositories.shopDAO.ShopDAOProductRepository;

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
        List<CategoryProducts> categoryProducts = shopDAOCategoryRepository.getAllByCategoriesNotNull();
        return categoryProducts;
    }

    @Override
    public List<Product> getProducts(String s) {
        List<CategoryProducts> list = shopDAOCategoryRepository.getAllByCategoriesIs(s);

        List<Product> listProducts = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            listProducts.add(shopDAOProductRepository
                    .getAllByCategory_Id(list.get(i).getId()).get(0));
        }
        return listProducts;
    }
}
