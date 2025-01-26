package raicod3.e_store.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raicod3.e_store.customer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String email);
    Customer findByPhone(String phone);

    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
