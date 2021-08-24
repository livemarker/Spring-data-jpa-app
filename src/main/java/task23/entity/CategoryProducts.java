package task23.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category_products")
public class CategoryProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Product> categories;

    public CategoryProducts(Integer id) {
        this.id = id;

    }

    public CategoryProducts() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Product> getCategories() {
        return categories;
    }

    public void setCategories(List<Product> categories) {
        this.categories = categories;
    }
}
