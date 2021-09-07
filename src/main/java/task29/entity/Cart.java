package task29.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private Integer id;
    @Column
    @JsonProperty
    private String nameProduct;
    @Column
    @JsonProperty
    private double price;
    @ManyToOne
    @JoinColumn
    @JsonProperty
    private Order order;

    public Cart(Integer id, String nameProduct, double price, Order order) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.order = order;

    }

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nameProduct;
    }

    public void setName(String namepProduct) {
        this.nameProduct = namepProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", namepProduct='" + nameProduct + '\'' +
                        ", price=" + price +
                        ", order=" + order +
                        '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

