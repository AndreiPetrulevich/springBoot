package ru.gb.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import ru.gb.springboot.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ConfigurationProperties("shop.properties")
@Getter
@Setter
public class ProductProps {
    private List<Product> products;

    private int countId;

    public Product addProduct(Product product) {
        product.setId(countId++);
        products.add(product);
        return Product.builder()
                .id(product.getId())
                .title(product.getTitle())
                .cost(product.getCost())
                .build();
    }

    public Optional<Product> getById(Integer id) {
        if (id < products.size()) {
            return Optional.of(products.get(id));
        } else {
            return Optional.empty();
        }
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public void deleteProductById(Integer id) {
        if (id < products.size()) {
            products.remove(id.intValue());
        }
    }

    public Product editProduct(Product product) {
        return products.set(product.getId(), product);
    }
}
