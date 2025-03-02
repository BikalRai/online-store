package raicod3.e_store.order.model;

import jakarta.persistence.*;
import raicod3.e_store.customer.model.Customer;
import raicod3.e_store.status.Status;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Customer customer;
    private LocalDateTime orderDate;
    private Status status;

    public Order() {
    }

    public Order(int id, Customer customer, LocalDateTime orderDate, Status status) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
