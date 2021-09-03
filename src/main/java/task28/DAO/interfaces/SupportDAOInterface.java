package task28.DAO.interfaces;

import task28.entity.Ticket;
import task28.entity.User;

import java.util.List;

public interface SupportDAOInterface {

    void addTicket(Ticket ticket);

    List<Ticket> getTicket(User user);

}
