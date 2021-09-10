package task30.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import task30.DAO.interfaces.CommentDAOInterface;
import task30.DAO.interfaces.ShopDAOInterface;
import task30.servises.ShopServiceInterface;

import java.sql.SQLException;

@Controller
public class ProductController {
    private CommentDAOInterface commentDAOInterface;
    private ShopDAOInterface shopDAOInterface;
    private ShopServiceInterface shopServiceInterface;

    @GetMapping("/product")
    public String getOneProduct(
            @RequestParam("id") Integer id,
            Model model) {

        model.addAttribute("oneProduct", shopDAOInterface.getOneProduct(id));
        model.addAttribute("comments", commentDAOInterface.getAllByProductIdIs(id));
        return "product";
    }

    @PostMapping("/product")
    public String addToCart(@RequestParam int id, Model model) throws SQLException {
        shopServiceInterface.addToCart(id);
        return getOneProduct(id, model);
    }

    @Autowired
    public void setCommentDAOInterface(CommentDAOInterface commentDAOInterface) {
        this.commentDAOInterface = commentDAOInterface;
    }

    @Autowired
    public void setShopServiceInterface(ShopServiceInterface shopServiceInterface) {
        this.shopServiceInterface = shopServiceInterface;
    }

    @Autowired
    public void setShopDAOInterface(ShopDAOInterface shopDAOInterface) {
        this.shopDAOInterface = shopDAOInterface;
    }
}
