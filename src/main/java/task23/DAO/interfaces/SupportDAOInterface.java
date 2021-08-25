package task23.DAO.interfaces;

import task23.entity.Ticket;
import task23.entity.User;

import java.util.List;

public interface SupportDAOInterface {

    void addTicket(Ticket ticket);

    List<Ticket> getTicket(User user);

}
