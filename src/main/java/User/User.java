package User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @OneToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;
    @OneToMany
    private List<Order> order;


    public User(){
    }

    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.basket = new Basket();
        BasketData.addBasket(this.basket);
        UserData.addUser(this);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(password.matches("^(.+)@(.+)$")){
            this.email = email;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.length()>=8) {
            this.password = password;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.matches("[A-Za-z]{3,}$")) {
            firstName = setValidLetters(firstName);
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.matches("[A-Za-z]{3,}$")) {
            lastName = setValidLetters(lastName);
            this.lastName = lastName;
        }
    }

    public Basket getBasket() {
        return basket;
    }

    private void setBasket(Basket basket){this.basket = basket;}

    private String setValidLetters(String name){
        int letters = name.length();
        String[] tempName = new String[letters];
        for(int i=0; i<letters-1; i++){
            if(i==0){
                tempName[i].toUpperCase();
            } else {
                tempName[i].toLowerCase();
            }
        }
        return tempName.toString();
    }
}
