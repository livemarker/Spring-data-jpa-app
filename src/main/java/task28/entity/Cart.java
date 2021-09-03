package task28.entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String nameProduct;
    @Column
    private double price;
    @ManyToOne
    @JoinColumn
    private Order order;

    public Cart(Integer id, String namepProduct, double price, Order order) {
        this.id = id;
        this.nameProduct = namepProduct;
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

