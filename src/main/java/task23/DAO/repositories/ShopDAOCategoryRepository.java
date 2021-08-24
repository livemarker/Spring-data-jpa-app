package task23.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import task23.entity.CategoryProducts;
import task23.entity.ListOrders;
import task23.entity.Product;

import java.util.List;
@Repository
public interface ShopDAOCategoryRepository extends JpaRepository<CategoryProducts,Integer> {

    List<CategoryProducts> getAllByCategoriesIs(String s);

    List<CategoryProducts> getAllByCategoriesNotNull();
}
