package raicod3.e_store.category.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import raicod3.e_store.category.dto.CategoryRequestDTO;
import raicod3.e_store.category.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // add a category
    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {

        if(categoryRequestDTO.getName() == null || categoryRequestDTO.getName().isEmpty()) {
            return new ResponseEntity<>("Category name cannot be empty", HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<>(categoryService.addCategory(categoryRequestDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred, please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // retrieve category using id
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable int id) {
        try {
            return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
        }catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }
    }

    // retrieve category using name
    @GetMapping("/categories/{name}")
    public ResponseEntity<?> getCategoryByName(@PathVariable("name") String name) {
        try {
            return new ResponseEntity<>(categoryService.getCategoryByName(name), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }
    }

    // retrieve all categories
    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String keyword) {
        try {
            return new ResponseEntity<>(categoryService.getAllCategories(keyword), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update category after retrieving using id
    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateCategory(@PathVariable int id, @Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {

        if(categoryRequestDTO.getName() == null || categoryRequestDTO.getName().isEmpty()) {
            return new ResponseEntity<>("Category name cannot be empty", HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<>(categoryService.updateCategory(id, categoryRequestDTO), HttpStatus.OK);
        }
         catch(EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
         }
        catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete category using id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        try {
            return new ResponseEntity<>(categoryService.deleteCategory(id), HttpStatus.OK);
        } catch(EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
