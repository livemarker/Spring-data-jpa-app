package task23.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import task23.entity.Order;


interface OrderRepository extends JpaRepository<Order, Integer> {

}
