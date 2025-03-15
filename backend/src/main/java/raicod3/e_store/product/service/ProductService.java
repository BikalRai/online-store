package raicod3.e_store.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
					.map(category -> categoryRepo.findByName(category.getName())).filter(category -> category != null)
					.collect(Collectors.toList());
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

	// get all products
	public List<ProductResponseDTO> getAllProdcuts(String productName, int limit) {
		try {
			List<Product> allProducts;

			if (productName != null && !(productName.isEmpty())) {
				allProducts = productRepo.findByNameContainingIgnoreCase(productName);
			} else {
				allProducts = productRepo.findAll();
			}

			return allProducts.stream().limit(limit).map(ProductResponseDTO::new).collect(Collectors.toList());
		} catch (Exception e) {
			throw new RuntimeException("Error retrieving all products, " + e.getMessage());
		}
	}

	// get a product using id
	public ProductResponseDTO getProductById(int productId) {
		try {
			Optional<Product> existingProduct = productRepo.findById(productId);

			if (!existingProduct.isPresent()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id = " + productId + "not found");
			}
			
			Product product = existingProduct.get();
			return new ProductResponseDTO(product);
		} catch (Exception e) {
			throw new RuntimeException("Error getting product with id: " + productId);
		}
	}

	// update product using id
	public ProductResponseDTO updateProduct(int id, ProductRequestDTO productRequestDTO) {
		try {

			Optional<Product> existingProduct = productRepo.findById(id);

			if (!existingProduct.isPresent()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id = " + id + "not found");
			}
			
			Product product = existingProduct.get();
			product.setName(productRequestDTO.getName());
			product.setPrice(productRequestDTO.getPrice());
			product.setCategories(productRequestDTO.getCategories().stream()
					.map(category -> categoryRepo.findByName(category.getName())).collect(Collectors.toList()));
			product.setImageUrls(productRequestDTO.getImageUrls());
			product.setDescription(productRequestDTO.getDescription());
			product.setQuantity(productRequestDTO.getQuantity());
			productRepo.save(product);
			return new ProductResponseDTO(product);

		} catch (Exception e) {
			throw new RuntimeException("Error updating product with id: " + id);
		}
	}
	
	//delete product using id
	public String deleteProductById(int productId) {
		try {
			Optional<Product> existingProduct = productRepo.findById(productId);
			if(!existingProduct.isPresent()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id: " + productId + " not found");
			}
			
			Product product = existingProduct.get();
			
			productRepo.deleteById(product.getId());
			
			return "Successfully delete product with id: " + productId;
			
		}catch (Exception e) {
			throw new RuntimeException("Error deleting product with id: " + productId);
		}
	}

}
