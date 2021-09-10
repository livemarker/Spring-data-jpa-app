package task30.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import task30.DAO.interfaces.SupportDAOInterface;
import task30.entity.User;
import task30.security.UserServiceInterface;

@Controller
public class SupportController {
    private SupportDAOInterface supportDAOInterface;
    private UserServiceInterface userServiceInterface;

    @RequestMapping(value = "/support", method = RequestMethod.GET)
    public String getCart(Model model) {
        model.addAttribute("supports", supportDAOInterface.getTicket(new User(userServiceInterface.getSecurityLogin())));
        return "support";
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
