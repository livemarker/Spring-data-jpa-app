package task29.DAO.interfaces;

import task29.entity.Ticket;
import task29.entity.User;

import java.util.List;

public interface SupportDAOInterface {

    void addTicket(Ticket ticket);

    List<Ticket> getTicket(User user);

}
