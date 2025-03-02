package raicod3.e_store.cart.model;

import jakarta.persistence.*;
import raicod3.e_store.customer.model.Customer;

import java.time.LocalDateTime;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "cart")
    private Customer customer;

    public Cart() {
    }

    public Cart(int id, LocalDateTime createdAt, Customer customer) {
        this.id = id;
        this.createdAt = createdAt;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
