package task28.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import task28.DAO.interfaces.ShopDAOInterface;

@Controller
public class ShopController {
    private ShopDAOInterface shopDAOInterface;

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String getCategory( Model model) {
        model.addAttribute("category", shopDAOInterface.getAllCategoryProducts());
        return "shop";
    }
    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public String getProduct(@PathVariable("category") String category, Model model) {
        model.addAttribute("products", shopDAOInterface.getProducts(category));
        return "products";
    }

    @Autowired
    public void setShopDAOInterface(ShopDAOInterface shopDAOInterface) {
        this.shopDAOInterface = shopDAOInterface;
    }
}
