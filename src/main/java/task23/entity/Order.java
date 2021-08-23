package task23.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import task23.DAO.OrderDAO;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Order {

    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private int orderNumber;
    @Column
    private String nameProduct;
    @Column
    private double price;
    @Column
    private String category;
    @Column
    private String status;

    public Order(int id, String name, String lastName, int orderNumber,
                 String nameProduct, double price, String category, String status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.orderNumber = orderNumber;
        this.nameProduct = nameProduct;
        this.price = price;
        this.category = category;
        this.status = status;
    }

    public Order() {
    }
}
