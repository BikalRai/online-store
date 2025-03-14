package raicod3.e_store.product.dto;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import raicod3.e_store.category.dto.CategoryResponseDTO;

public class ProductRequestDTO {

	@NotBlank(message = "Product name cannot be blank")
	@Size(min = 3, max = 255, message = "Product name must be between 3 and 255 characters")
	private String name;

	@NotEmpty(message = "Select at least one category")
	private List<CategoryResponseDTO> categories;

	@NotNull(message = "Price cannot be null")
	@DecimalMin(value = "0.00", inclusive = false, message = "Price must be greater than 0.00")
	@Digits(integer = Integer.MAX_VALUE, fraction = 2, message = "Price must have exactly 2 decimal places")
	private BigDecimal price;

	@NotNull(message = "Product must have at least one image")
	private List<String> imageUrls;

	@Size(max = 1000, message = "Description cannot exceed 1000 characters")
	private String description;

	@Min(value = 1, message = "Quantity must be at least 1")
	private int quantity;

	public ProductRequestDTO() {

	}

	public ProductRequestDTO(String name, List<CategoryResponseDTO> categories, BigDecimal price,
			List<String> imageUrls, String description, int quantity) {

		this.name = name;
		this.categories = categories;
		this.price = price;
		this.imageUrls = imageUrls;
		this.description = description;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryResponseDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryResponseDTO> categories) {
		this.categories = categories;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductRequestDTO [name=" + name + ", categories=" + categories + ", price=" + price + ", imageUrls="
				+ imageUrls + ", description=" + description + ", quantity=" + quantity + "]";
	}

}
