package task23.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "list_orders")
public class ListOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column
    String login;
    @OneToMany(mappedBy = "listOrders", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Order> orders;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
