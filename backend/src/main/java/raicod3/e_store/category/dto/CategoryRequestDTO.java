package raicod3.e_store.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryRequestDTO {

	private int id;

	@NotBlank(message = "Category name cannot be blank")
	@Size(min = 3, max = 255, message = "Product name must be between 3 and 255 characters")
	private String name;

	@Size(max = 1000, message = "Description cannot exceed 1000 characters")
	private String description;

	public CategoryRequestDTO() {

	}

	public CategoryRequestDTO(int id, String name, String description) {

		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CategoryRequestDTO [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
