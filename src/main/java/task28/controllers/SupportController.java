package task28.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import task28.DAO.interfaces.SupportDAOInterface;
import task28.entity.User;

@Controller
public class SupportController {
    private SupportDAOInterface supportDAOInterface;

    @RequestMapping(value = "/support", method = RequestMethod.GET)
    public String getTickets(Model model) {
        model.addAttribute("supports", supportDAOInterface.getTicket(new User("Никита")));
        return "support";
    }

    @Autowired
    public void setSupportDAOInterface(SupportDAOInterface supportDAOInterface) {
        this.supportDAOInterface = supportDAOInterface;
    }
}
