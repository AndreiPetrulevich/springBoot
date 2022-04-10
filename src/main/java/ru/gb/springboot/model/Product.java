package ru.gb.springboot.model;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    Integer id;
    String title;
    BigDecimal cost;

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return id.equals(product.id);
    }

    @Override
    public String toString() {
        return "Product: id = " + this.id + ", title = " + this.title + ", cost = " + this.cost;
    }
}
