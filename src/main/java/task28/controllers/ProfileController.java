package task28.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import task28.DAO.interfaces.UserDAOInterface;

@Controller
public class ProfileController {
    private UserDAOInterface userDAOInterface;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getCart(Model model) {
        model.addAttribute("user", userDAOInterface.load("Никита"));
        return "profile";
    }

    @Autowired
    public void setUserDAOInterface(UserDAOInterface userDAOInterface) {
        this.userDAOInterface = userDAOInterface;
    }
}
