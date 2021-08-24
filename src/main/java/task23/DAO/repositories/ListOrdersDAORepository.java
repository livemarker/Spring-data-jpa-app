package task23.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task23.entity.ListOrders;

public interface ListOrdersDAORepository extends JpaRepository<ListOrders,Integer> {
}
