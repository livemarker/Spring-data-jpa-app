package task23.entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private double price;
    @ManyToOne
    @JoinColumn
    private CategoryProducts category;

    public Product(Integer id, String name, double price, CategoryProducts category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryProducts getCategory() {
        return category;
    }

    public void setCategory(CategoryProducts category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return
                "/name='" + name + '\'' +
                ", price=" + price;
    }
}

