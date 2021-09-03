package task28.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task28.DAO.interfaces.SupportDAOInterface;
import task28.DAO.repositories.SupportDAORepository;
import task28.entity.Ticket;
import task28.entity.User;

import java.util.List;

@Service
public class SupportDAO implements SupportDAOInterface {
    private SupportDAORepository supportDAORepository;

    @Override
    public void addTicket(Ticket ticket) {
        supportDAORepository.save(ticket);
    }

    public List<Ticket> getTicket(User user) {
        return supportDAORepository.getAllByLoginIs(user.getLogin());
    }

    @Autowired
    public void setSupportDAORepository(SupportDAORepository supportDAORepository) {
        this.supportDAORepository = supportDAORepository;
    }
}
