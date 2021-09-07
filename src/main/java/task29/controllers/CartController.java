package task29.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task29.DAO.interfaces.OrderDAOInterface;
import task29.DAO.repositories.CartDAORepository;
import task29.dto.CartDto;
import task29.entity.Cart;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController {
    private OrderDAOInterface orderDAOInterface;
    private CartDAORepository cartDAORepository;

    @GetMapping(value = "/cart")
    public List<CartDto> getCart(@RequestParam String login) {
        List<Cart> cart = orderDAOInterface.getUserCart(login);
        List<CartDto> viewCart = new ArrayList<>();
        for (Cart c : cart) {
            viewCart.add(new CartDto(c.getId(), c.getName(), c.getPrice()));
        }
        return viewCart;
    }

    @PutMapping(value = "/cart/edit")
    public void editCart(@RequestParam int id, @RequestBody CartDto cartDto) {
        Cart cart = orderDAOInterface.getCartByID(id);
        cartDAORepository.save(
                new Cart(
                        cart.getId(),
                        cartDto.getNameProduct(),
                        cartDto.getPrice(),
                        cart.getOrder()));
    }

    @DeleteMapping(value = "/cart/delete")
    public void clearCart(@RequestParam String login) {
        orderDAOInterface.delCart(login);
    }

    @Autowired
    public void setOrderDAOInterface(OrderDAOInterface orderDAOInterface) {
        this.orderDAOInterface = orderDAOInterface;
    }

    @Autowired
    public void setCartDAORepository(CartDAORepository cartDAORepository) {
        this.cartDAORepository = cartDAORepository;
    }
}
