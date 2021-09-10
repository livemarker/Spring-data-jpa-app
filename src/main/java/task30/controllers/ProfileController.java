package task30.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import task30.DAO.interfaces.UserDAOInterface;
import task30.security.UserServiceInterface;

@Controller
public class ProfileController {
    private UserDAOInterface userDAOInterface;
    private UserServiceInterface userServiceInterface;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getCart(Model model) {


        model.addAttribute("user", userDAOInterface.load(userServiceInterface.getSecurityLogin()));
        return "profile";
    }

    @Autowired
    public void setUserServiceInterface(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @Autowired
    public void setUserDAOInterface(UserDAOInterface userDAOInterface) {
        this.userDAOInterface = userDAOInterface;
    }
}
