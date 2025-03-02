package raicod3.e_store.payment.model;

import jakarta.persistence.*;
import raicod3.e_store.order.model.Order;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String paymentMethod;

    private double amount;
}
