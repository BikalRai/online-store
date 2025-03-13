package raicod3.e_store.product.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import raicod3.e_store.category.model.Category;
import raicod3.e_store.category.repository.CategoryRepository;
import raicod3.e_store.product.dto.ProductRequestDTO;
import raicod3.e_store.product.dto.ProductResponseDTO;
import raicod3.e_store.product.model.Product;
import raicod3.e_store.product.repository.ProductRepository;
import raicod3.e_store.utility.CustomException;

@Service
public class ProductService {

	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;

	public ProductService(ProductRepository productRepo, CategoryRepository categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}

//	service layer to create/add a product
	public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) throws CustomException {
		try {
			Product newProduct = new Product();

			// map the new product details from the requestDTO
			newProduct.setName(productRequestDTO.getName());
			List<Category> categories = productRequestDTO.getCategories().stream()
					.map(category -> categoryRepo.findById(category.getId())
							.orElseThrow(() -> new RuntimeException("category not found: " + category.getId())))
					.filter(category -> category != null).collect(Collectors.toList());
			newProduct.setCategories(categories);

			newProduct.setPrice(productRequestDTO.getPrice());
			newProduct.setImageUrls(productRequestDTO.getImageUrls());
			newProduct.setDescription(productRequestDTO.getDescription());
			newProduct.setQuantity(productRequestDTO.getQuantity());

			// save the new product
			Product savedProduct = productRepo.save(newProduct);

			// map the product back to the responseDTO
			ProductResponseDTO productResponseDTO = new ProductResponseDTO(savedProduct);

			return productResponseDTO;
		} catch (Exception e) {
			throw new CustomException("error creating new product, " + e.getMessage());
		}
	}

}
