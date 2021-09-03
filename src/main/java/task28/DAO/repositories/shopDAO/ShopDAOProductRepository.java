package task28.DAO.repositories.shopDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import task28.entity.Product;

import java.util.List;


public interface ShopDAOProductRepository extends JpaRepository<Product, Integer> {

    List<Product> getAllByCategory_Id(int id);

}
