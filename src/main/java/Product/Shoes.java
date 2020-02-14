package Product;

import javax.persistence.Column;

public class Shoes extends Product{
    @Column(name = "product_type", nullable = false)
    private final String PRODUCT_TYPE = "SHOES";
    @Column(name = "size", nullable = false)
    private double size;
    public Shoes(String name, String description, double value, int quantity, double size) {
        super(name, description, value, quantity);
        this.size = size;
    }
}
