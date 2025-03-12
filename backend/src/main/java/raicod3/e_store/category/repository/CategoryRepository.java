package raicod3.e_store.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import raicod3.e_store.category.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT c FROM Category c WHERE c.id = :id")
    Category getCategoryById(@PathVariable("id") int id);

    List<Category> findByNameContainingIgnoreCase(String name);
    
    Category findByName(String name);
}
