package ru.geekbrains.persist;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.persist.model.Product;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ProductSpecification {

    public static Specification<Product> byCategory(long categoryId) {
        return (root, query, builder) -> builder.equal(root.get("category").get("id"), categoryId);
    }

    public static Specification<Product> byName(String pattern) {
        return (root, query, builder) -> builder.like(root.get("name"), "%" + pattern + "%");
    }

    public static Specification<Product> minPriceFilter(BigDecimal minPrice) {
        return (root, query, builder) -> builder.ge(root.get("price"), minPrice);
    }

    public static Specification<Product> maxPriceFilter(BigDecimal maxPrice) {
        return (root, query, builder) -> builder.le(root.get("price"), maxPrice);
    }

    public static Specification<Product> byManufacturerId(ArrayList<Long> manufacturerIds) {
        return (root, query, builder) -> {
            CriteriaBuilder.In<Long> inClause = builder.in(root.get("manufacturer").get("id"));
            manufacturerIds.stream().forEach(inClause::value);
            return inClause;
        };
    }
}
