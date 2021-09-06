package task28.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import task28.DAO.interfaces.ShopDAOInterface;

@Controller
public class ShopController {
    private ShopDAOInterface shopDAOInterface;

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String getCategory( Model model) {
        model.addAttribute("category", shopDAOInterface.getAllCategoryProducts());
        return "shop";
    }
    @GetMapping("/{category}")
    public String getProduct(@PathVariable("category") String category, Model model) {
        model.addAttribute("products", shopDAOInterface.getProducts(category));
        return "products";
    }

    @Autowired
    public void setShopDAOInterface(ShopDAOInterface shopDAOInterface) {
        this.shopDAOInterface = shopDAOInterface;
    }
}
