package task29.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task29.DAO.interfaces.SupportDAOInterface;
import task29.entity.Ticket;
import task29.entity.User;

import java.util.List;

@RestController
public class SupportController {
    private SupportDAOInterface supportDAOInterface;

    @GetMapping(value = "/support")
    public List<Ticket> getTickets(@RequestParam String login) {
        return supportDAOInterface.getTicket(new User(login));
    }

    @Autowired
    public void setSupportDAOInterface(SupportDAOInterface supportDAOInterface) {
        this.supportDAOInterface = supportDAOInterface;
    }
}
