package task29.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import task29.DAO.interfaces.ShopDAOInterface;
import task29.dto.ProductDto;
import task29.entity.CategoryProducts;
import task29.entity.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShopController {
    private ShopDAOInterface shopDAOInterface;


    @GetMapping(value = "/shop", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoryProducts> getCategory() {
        List<CategoryProducts> list = shopDAOInterface.getAllCategoryProducts();
        return list;
    }

    @GetMapping(value = "/{category}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getProduct(@PathVariable String category) {
        List<Product> products = shopDAOInterface.getProducts(category);
        List<ProductDto> productDtos = new ArrayList<>();

        for (Product p : products) {
            productDtos.add(new ProductDto(p.getId(), p.getName(), p.getPrice()));
        }
        return productDtos;
    }

    @Autowired
    public void setShopDAOInterface(ShopDAOInterface shopDAOInterface) {
        this.shopDAOInterface = shopDAOInterface;
    }
}
