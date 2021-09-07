package task29.DAO.repositories.shopDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task29.entity.CategoryProducts;

import java.util.List;

@Repository
public interface ShopDAOCategoryRepository extends JpaRepository<CategoryProducts, Integer> {

    List<CategoryProducts> getAllByCategoriesIs(String s);

    List<CategoryProducts> getAllByCategoriesNotNull();
}
