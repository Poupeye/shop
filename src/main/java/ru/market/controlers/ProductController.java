package ru.market.controlers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.market.dto.ProductDto;
import ru.market.exception_handling.ResourceNotFoundException;
import ru.market.model.Product;
import ru.market.repositories.specifikation.ProductSpecification;
import ru.market.services.ProductService;


@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public Page<ProductDto> getAllProduct (@RequestParam MultiValueMap<String,String> params,
            @RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        if (page<1){
            page=1;
        }
        return productService.getAllProduct(ProductSpecification.build(params),page, 5);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductDtoById(id).orElseThrow(()->new ResourceNotFoundException("Product with id:" + id + " doesn't exist"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product) {
        product.setId(null);
        return productService.saveOrUpdate(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

    @DeleteMapping ("/{id}")
    public void  deleteProductById (@PathVariable Long id) {
        productService.deleteProductById(id);
    }

}
