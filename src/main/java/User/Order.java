package User;

import Product.Product;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @NotNull
    private String status;
    @ManyToMany
    @JoinTable(name = "ORDER_PRODUCT", joinColumns = {@JoinColumn(referencedColumnName = "ID")}
            ,inverseJoinColumns = {@JoinColumn(referencedColumnName = "ID")})
    private Set<Product> productSet = new HashSet<Product>();
    @NotNull
    private double totalValue;

    public Order(){ }

    public Order(User user) {
        this.user = user;
        this.status = "Waiting for payment";
        this.totalValue = user.getBasket().getTotalValue();
        this.productSet = user.getBasket().getProductSet();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
