package raicod3.e_store.category.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import raicod3.e_store.category.model.Category;
import raicod3.e_store.category.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) {
        try {
            return categoryRepository.save(category);
        } catch (Exception e) {
            throw new RuntimeException("Error while adding new category" + e.getMessage());
        }
    }

    public List<Category> getAllCategories() {
        try {
            return categoryRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error while getting all categories" + e.getMessage());
        }
    }

    public Category updateCategory(int id, Category category) {

        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " not found"));

        if (existingCategory.getName() == null) {
            throw new RuntimeException("Category not found");
        }

            existingCategory.setName(category.getName());
            existingCategory.setDescription(category.getDescription());

            return categoryRepository.save(existingCategory);

    }

    public String deleteCategory(int id) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " not found"));

        categoryRepository.delete(existingCategory);

        return "Category with id " + id + " deleted";
    }
}
