package task28.DAO.repositories;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import task28.entity.Cart;
import task28.entity.Order;


public interface CartDAORepository extends JpaRepository<Cart, Integer> {

    @Modifying
    @Transactional
    void deleteCartByOrderIs(Order id);

}
