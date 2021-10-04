package task30.DAO.repositories.shopDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import task30.entity.Product;

import java.util.List;


public interface ShopDAOProductRepository extends JpaRepository<Product, Integer> {

    List<Product> getAllByCategory_Id(int id);

    Product getByIdIs(int id);
}
