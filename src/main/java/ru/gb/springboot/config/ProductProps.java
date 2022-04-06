package ru.gb.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import ru.gb.springboot.model.Product;

import java.util.List;

@ConfigurationProperties("shop.properties")
@Getter
@Setter
public class ProductProps {
    private List<Product> products;
}
