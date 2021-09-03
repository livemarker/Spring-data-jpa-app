package task28.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    @RequestMapping(value = "/main")
    public void getMain() {

    }

    @RequestMapping(value = "/registration")
    public void registration() {
    }

    @RequestMapping(value = "/signIn")
    public void signIn() {
    }
    @RequestMapping(value = "/account")
    public void account() {
    }

}
