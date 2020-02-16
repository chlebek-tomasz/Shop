package User;

import Product.Product;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @NotNull
    private String status;
    @OneToMany
    private List<Product> productList;
    @NotNull
    private double totalValue;
    @OneToOne
    private Bracket bracket;

    public Order(){ }

    public Order(User user, Bracket bracket) {
        this.user = user;
        this.bracket = bracket;
        this.status = "Waiting for payment";
        this.totalValue = bracket.getTotalValue();
        this.productList = bracket.getProductList();
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
