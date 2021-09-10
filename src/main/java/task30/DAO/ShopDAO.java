package task30.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task30.DAO.interfaces.ShopDAOInterface;
import task30.DAO.repositories.shopDAO.ShopDAOCategoryRepository;
import task30.entity.CategoryProducts;
import task30.entity.Product;
import task30.DAO.repositories.shopDAO.ShopDAOProductRepository;

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

    public List<CategoryProducts> getAllCategoryProducts() {
        return shopDAOCategoryRepository.getAllByCategoriesNotNull();
    }

    @Override
    public List<Product> getProducts(String s) {
        List<CategoryProducts> list = shopDAOCategoryRepository.getAllByCategoriesIs(s);

        List<Product> listProducts = new ArrayList<>();

        for (int i = 0; i < list.get(0).getCategoryList().size(); i++) {
            listProducts.add(shopDAOProductRepository
                    .getAllByCategory_Id(list.get(0).getId()).get(i));
        }

        return listProducts;
    }


    public Product getOneProduct(int id) {
        return shopDAOProductRepository.getByIdIs(id);
    }

    public List<CategoryProducts> getCategory(String category) {
        return shopDAOCategoryRepository.getAllByCategoriesIs(category);
    }

}
