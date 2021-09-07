package task29.DAO.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import task29.entity.Order;

import java.util.List;

public interface OrderDAORepository extends JpaRepository<Order, Integer> {
    List<Order> getAllByLoginIs(String login);

    @Modifying
    @Transactional
    @Query("update Order o SET o.status=:newStatus where o.status=:status and o.login=:login")
    void changeStatus(String login, String status, String newStatus);

    @Query("SELECT o from Order o where o.login=:login and o.status=:status")
    List<Order> getAllByOrder_LoginAndOrder_Status(String login, String status);

    @Modifying
    @Transactional
    @Query("DELETE from Order o where o.login=:login and o.status=:status")
    void delAllByOrder_LoginAndOrder_Status(String login, String status);
}
