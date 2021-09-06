package task28.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import task28.DAO.interfaces.CommentDAOInterface;
import task28.DAO.interfaces.ShopDAOInterface;

@Controller
public class ProductController {
    private CommentDAOInterface commentDAOInterface;
    private ShopDAOInterface shopDAOInterface;


    @GetMapping("/product")
    public String getOneProduct(
            @RequestParam("id") Integer id,
            Model model) {

        model.addAttribute("oneProduct", shopDAOInterface.getOneProduct(id));
        model.addAttribute("comments", commentDAOInterface.getAllByProductIdIs(id));
        System.out.println(1111111 + " " + id);
        return "product";
    }

    @Autowired
    public void setCommentDAOInterface(CommentDAOInterface commentDAOInterface) {
        this.commentDAOInterface = commentDAOInterface;
    }

    @Autowired
    public void setShopDAOInterface(ShopDAOInterface shopDAOInterface) {
        this.shopDAOInterface = shopDAOInterface;
    }
}
