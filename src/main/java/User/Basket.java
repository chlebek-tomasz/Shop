package User;

import Product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Transient
    @OneToOne
    private User user;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "BASKET_PRODUCT", joinColumns = {@JoinColumn(referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "ID")})
    private Set<Product> productSet = new HashSet<Product>();
    @Column(name = "totalValue")
    private double totalValue = 0;

    public Basket(){}

    public Long getId(){ return id; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
