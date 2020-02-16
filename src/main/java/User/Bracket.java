package User;

import Product.Product;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bracket")
public class Bracket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany
    private List<Product> productList;
    @Column(name = "totalValue")
    private double totalValue;

    public Bracket() {
        BracketDAO.addBracket(this);
        this.totalValue = 0;
    }

    public Long getId(){ return id; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
