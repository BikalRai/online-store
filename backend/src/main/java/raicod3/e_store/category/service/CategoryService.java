package raicod3.e_store.category.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import raicod3.e_store.category.dto.CategoryRequestDTO;
import raicod3.e_store.category.dto.CategoryResponseDTO;
import raicod3.e_store.category.model.Category;
import raicod3.e_store.category.repository.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {

		this.categoryRepository = categoryRepository;
	}

	public Category addCategory(CategoryRequestDTO categoryRequestDTO) {
		try {
			Category category = new Category();
			category.setName(categoryRequestDTO.getName());
			category.setDescription(categoryRequestDTO.getDescription());
			return categoryRepository.save(category);
		} catch (Exception e) {
			throw new RuntimeException("Error while adding new category" + e.getMessage());
		}
	}

	public CategoryResponseDTO getCategoryByName(String name) {

		Category category = categoryRepository.findByName(name);

		CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO(category);

		if (category == null) {
			throw new EntityNotFoundException("Category not found with name " + name);
		}
		return categoryResponseDTO;

	}

	public CategoryResponseDTO getCategoryById(int id) {
		Optional<Category> existingCategory = categoryRepository.findById(id);

		if (existingCategory.isPresent()) {
			Category category = existingCategory.get();

			CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO(category);

			return categoryResponseDTO;
		} else {
			throw new EntityNotFoundException("Category not found with id: " + id);
		}

	}

	public List<CategoryResponseDTO> getAllCategories(String keyword) {
		try {
			List<Category> categories;
			if (keyword != null && !keyword.isEmpty()) {
				categories = categoryRepository.findByNameContainingIgnoreCase(keyword);
			} else {
				categories = categoryRepository.findAll();
			}

			return categories.stream().map(CategoryResponseDTO::new).collect(Collectors.toList());
		} catch (Exception e) {
			throw new RuntimeException("Error while getting all categories" + e.getMessage());
		}
	}

	public Category updateCategory(int id, CategoryRequestDTO categoryRequestDTO) {

		Category existingCategory = categoryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " not found"));

		if (existingCategory.getName() == null) {
			throw new RuntimeException("Category not found");
		}

		existingCategory.setName(categoryRequestDTO.getName());
		existingCategory.setDescription(categoryRequestDTO.getDescription());

		return categoryRepository.save(existingCategory);

	}

	public String deleteCategory(int id) {
		Category existingCategory = categoryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " not found"));

		categoryRepository.delete(existingCategory);

		return "Category with id " + id + " deleted";
	}
}
