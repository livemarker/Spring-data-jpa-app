package task30.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task30.DAO.interfaces.SupportDAOInterface;
import task30.DAO.repositories.SupportDAORepository;
import task30.entity.Ticket;
import task30.entity.User;

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
