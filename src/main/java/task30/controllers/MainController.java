package task30.controllers;


import liquibase.pro.packaged.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import task30.DAO.interfaces.UserDAOInterface;
import task30.entity.User;

import java.sql.SQLException;

@Controller
public class MainController {
    @Autowired
    private UserDAOInterface userDAOInterface;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @RequestMapping(value = "/main")
    public void getMain() {

    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationPage() {
        return "registration";

    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestParam String login,
                                @RequestParam String password,
                                @RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam String address,
                                @RequestParam String phoneNumber) throws SQLException {

        userDAOInterface.save(new User(login, encoder.encode(password), firstName, lastName, address, phoneNumber));
        return "redirect:/account";
    }


    @RequestMapping(value = "/account")
    public void account() {

    }

}
