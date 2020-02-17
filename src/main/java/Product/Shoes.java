package Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Shoes extends Product{
    @Column(name = "size", nullable = false)
    private double size;

    public Shoes(){}

    public Shoes(String name, Category category, String description, double value, int quantity, double size) {
        super(name, category, description, value, quantity);
        this.size = size;
    }
}
