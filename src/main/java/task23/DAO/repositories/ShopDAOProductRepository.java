package task23.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task23.entity.CategoryProducts;
import task23.entity.Product;

import java.util.List;


public interface ShopDAOProductRepository extends JpaRepository<Product, Integer> {

    List<Product> getAllByCategory_Id(int id);

}
