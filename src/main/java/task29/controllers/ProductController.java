package task29.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import task29.DAO.interfaces.CommentDAOInterface;
import task29.DAO.interfaces.ShopDAOInterface;
import task29.dto.ProductDto;
import task29.entity.Comment;
import task29.entity.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    private CommentDAOInterface commentDAOInterface;
    private ShopDAOInterface shopDAOInterface;


    @GetMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<ProductDto, List<Comment>> getOneProduct(
            @RequestParam("id") Integer id) {

        Map<ProductDto, List<Comment>> productMap = new HashMap<>();
        Product p = shopDAOInterface.getOneProduct(id);

        ProductDto productDto = new ProductDto(p.getId(), p.getName(), p.getPrice());
        List<Comment> comments = commentDAOInterface.getAllByProductIdIs(id);
        productMap.put(productDto, comments);

        return productMap;
    }

    @DeleteMapping(value = "/product/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneProduct(@RequestParam("id") Integer id) {
        shopDAOInterface.delOneProduct(id);
    }

    @PutMapping(
            value = "/product/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<ProductDto, List<Comment>> updateOneProduct(
            @RequestParam("id") Integer id, @RequestBody ProductDto productDto) {

        Map<ProductDto, List<Comment>> productMap = new HashMap<>();
        Product p = shopDAOInterface.getOneProduct(id);
        List<Comment> comments = commentDAOInterface.getAllByProductIdIs(id);

        productDto.setId(id);
        shopDAOInterface.updateOneProduct(new Product(p.getId(), productDto.getName(), productDto.getPrice(), p.getCategory()));
        productMap.put(productDto, comments);

        return productMap;
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
