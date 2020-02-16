package Product;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(name = "category_name")
    private String categoryName;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Product product;

    public Category() {
    }

    public Category(String categoryName){
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
