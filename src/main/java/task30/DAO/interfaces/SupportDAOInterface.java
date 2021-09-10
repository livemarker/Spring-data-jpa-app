package task30.DAO.interfaces;

import task30.entity.Ticket;
import task30.entity.User;

import java.util.List;

public interface SupportDAOInterface {

    void addTicket(Ticket ticket);

    List<Ticket> getTicket(User user);

}
