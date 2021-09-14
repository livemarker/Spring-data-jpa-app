package task30.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import task30.DAO.interfaces.SupportDAOInterface;
import task30.entity.Ticket;
import task30.entity.User;
import task30.security.UserServiceInterface;

@Controller
public class SupportController {
    private SupportDAOInterface supportDAOInterface;
    private UserServiceInterface userServiceInterface;
    private final String DEFAULT_STATUS ="в процессе рассмотрения";

    @RequestMapping(value = "/support", method = RequestMethod.GET)
    public String getTicket(Model model) {
        model.addAttribute("supports", supportDAOInterface.getTicket(new User(userServiceInterface.getSecurityLogin())));
        return "support";
    }

    @GetMapping(value = "/supportAdd")
    public String getAddTicket() {
        return "supportAdd";
    }

    @PostMapping(value = "/supportAdd")
    public String addTicket(@RequestParam String title, @RequestParam String text) {
        supportDAOInterface.addTicket(new Ticket(null,userServiceInterface.getSecurityLogin(),title,text,DEFAULT_STATUS));
        return "redirect:/support";
    }

    @Autowired
    public void setUserServiceInterface(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @Autowired
    public void setSupportDAOInterface(SupportDAOInterface supportDAOInterface) {
        this.supportDAOInterface = supportDAOInterface;
    }
}
