package raicod3.e_store.product.dto;

import java.util.List;

import raicod3.e_store.category.dto.CategoryResponseDTO;

public class ProductRequestDTO {
	
	private int id;
	private String name;
	private List<CategoryResponseDTO> categories;
	private double price;
	private String imageUrl;
	private String description;
	private int quantity;
	

}
