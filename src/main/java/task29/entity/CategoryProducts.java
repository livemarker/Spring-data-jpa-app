package task29.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private Integer id;
    @Column
    @JsonProperty
    private String categories;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty
    private List<Product> categoryList;

    public CategoryProducts(Integer id, String categories) {
        this.id = id;
        this.categories = categories;
    }

    public CategoryProducts() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Product> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Product> categories) {
        this.categoryList = categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "CategoryProducts{" +
                "id=" + id +
                ", categories='" + categories + '\'' +
                ", categoryList=" + categoryList +
                '}';
    }
}
