package raicod3.e_store.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raicod3.e_store.category.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
