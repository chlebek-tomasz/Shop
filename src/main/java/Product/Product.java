package Product;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    @Column(name = "name", nullable = false)
    private String name;
    private String description;
    private double value;
    private int quantity;
    private boolean inStock;
}
