package task29.DAO.repositories;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import task29.entity.Cart;
import task29.entity.Order;


public interface CartDAORepository extends JpaRepository<Cart, Integer> {

    @Modifying
    @Transactional
    void deleteCartByOrderIs(Order id);

}
