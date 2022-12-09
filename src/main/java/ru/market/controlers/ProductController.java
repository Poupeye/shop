package ru.market.controlers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.market.model.Product;
import ru.market.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public List<Product> getAllProduct () {
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping ("/delete/{id}")
    public void  deleteProductById (@PathVariable Long id) {
        productService.deleteProductById(id);
    }

}
