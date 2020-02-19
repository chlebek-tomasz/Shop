package Product;

import User.Basket;
import User.Order;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Product")
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToOne
    private Category category;
    @Column(name = "description")
    private String description;
    @Column(name = "value", nullable = false)
    private double value;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @ManyToMany(mappedBy = "productSet", fetch = FetchType.EAGER)
    private Set<Basket> basketSet = new HashSet<Basket>();
    @ManyToMany(mappedBy = "orderProductSet", fetch = FetchType.EAGER)
    private Set<Order> orderSet = new HashSet<Order>();

    public Product(){}

    public Product(String name, Category category, String description, double value, int quantity) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.value = value;
        this.quantity = quantity;
        ProductData.addProduct(this);
    }

    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
