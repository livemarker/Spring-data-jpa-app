package task30.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import task30.DAO.interfaces.ShopDAOInterface;
import task30.entity.Product;

import java.util.List;

@Controller
public class ShopController {
    private ShopDAOInterface shopDAOInterface;

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String getCategory(Model model) {
        model.addAttribute("category", shopDAOInterface.getAllCategoryProducts());
        return "shop";
    }

    @GetMapping("/category")
    public String getProduct(@RequestParam("name") String category, Model model) {
        List<Product> list = shopDAOInterface.getProducts(category);
        model.addAttribute("products", list);
        return "/products";
    }


    @Autowired
    public void setShopDAOInterface(ShopDAOInterface shopDAOInterface) {
        this.shopDAOInterface = shopDAOInterface;
    }
}
