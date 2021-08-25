package task23.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task23.entity.Ticket;

import java.util.List;

public interface SupportDAORepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> getAllByLoginIs(String login);
}
