package ru.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.market.bean.Cart;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CartDto {
    private List<OrderItemDto> items;
    private  int totalPrice;

    public CartDto(Cart cart) {
        this.totalPrice = cart.getTotalPrice();
        this.items = cart.getItems().stream().map(OrderItemDto::new).collect(Collectors.toList());
    }
}
