package raicod3.e_store.category.dto;

import raicod3.e_store.category.model.Category;

public class CategoryResponseDTO {

	private int id;
	private String name;
	private String description;

	public CategoryResponseDTO() {

	}

	public CategoryResponseDTO(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.description = category.getDescription();
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
		return "CategoryResponseDTO [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
