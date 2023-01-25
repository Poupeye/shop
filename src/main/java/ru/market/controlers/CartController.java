package ru.market.controlers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.market.bean.Cart;
import ru.market.dto.CartDto;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final Cart cart;

    @GetMapping
    public CartDto getCart() {
        return new CartDto(cart);
    }

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cart.addToCart(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cart.clear();
    }

    @DeleteMapping ("/{id}")
    public void  deleteCartById (@PathVariable Long id) {
        cart.deleteCartById(id);
    }
}
