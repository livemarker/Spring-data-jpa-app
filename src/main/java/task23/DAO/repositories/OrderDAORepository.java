package task23.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task23.entity.Order;

public interface OrderDAORepository extends JpaRepository<Order,Integer> {
}
