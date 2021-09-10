package task30.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task30.entity.Ticket;

import java.util.List;

public interface SupportDAORepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> getAllByLoginIs(String login);
}
