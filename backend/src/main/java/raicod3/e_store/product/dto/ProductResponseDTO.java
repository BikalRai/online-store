package raicod3.e_store.product.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import raicod3.e_store.category.dto.CategoryResponseDTO;
import raicod3.e_store.category.model.Category;
import raicod3.e_store.product.model.Product;

public class ProductResponseDTO {

	private int id;
	private String name;
	private List<Category> categories;
	private BigDecimal price;
	private List<String> imageUrls;
	private String description;
	private int quantity;

	public ProductResponseDTO() {

	}

	public ProductResponseDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.description = product.getDescription();
		this.quantity = product.getQuantity();
		this.categories = product.getCategories().stream().collect(Collectors.toList());
		this.imageUrls = product.getImageUrls().stream().collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
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
		return "ProductResponseDTO [id=" + id + ", name=" + name + ", categories=" + categories + ", price=" + price
				+ ", imageUrls=" + imageUrls + ", description=" + description + ", quantity=" + quantity + "]";
	}

}
