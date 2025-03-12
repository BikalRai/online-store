package raicod3.e_store.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import raicod3.e_store.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
