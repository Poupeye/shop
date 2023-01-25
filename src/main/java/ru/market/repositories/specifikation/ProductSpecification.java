package ru.market.repositories.specifikation;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import ru.market.model.Product;


public class ProductSpecification {

    private static Specification<Product> priceGreaterOrEqualsThan(Double minPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    private static Specification<Product> priceLesserOrEqualsThan(Double maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    private static Specification<Product> titleLike(String titlePart) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }

    public static Specification<Product> build(MultiValueMap<String, String> params) {
        Specification<Product> spec = Specification.where(null);
        if (params.containsKey("min_Price") && !params.getFirst("min_price").isBlank()) {
            spec = spec.and(ProductSpecification.priceGreaterOrEqualsThan((double) Integer.parseInt(params.getFirst("min_price"))));
        }
        if (params.containsKey("max_Price") && !params.getFirst("max_price").isBlank()){
            spec = spec.and(ProductSpecification.priceLesserOrEqualsThan((double) Integer.parseInt(params.getFirst("max_price"))));
        }
        if (params.containsKey("title") && !params.getFirst("title").isBlank()) {
            spec = spec.and(ProductSpecification.titleLike(params.getFirst("title")));
        }
        return spec;
    }

}
