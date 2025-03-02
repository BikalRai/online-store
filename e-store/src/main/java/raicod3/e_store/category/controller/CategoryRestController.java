package raicod3.e_store.category.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raicod3.e_store.category.model.Category;
import raicod3.e_store.category.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {

        if(category.getName() == null || category.getName().isEmpty()) {
            return new ResponseEntity<>("Category name cannot be empty", HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred, please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // endpoint for retrieving all categories
    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        try {
            return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody Category category) {

        if(category.getName() == null || category.getName().isEmpty()) {
            return new ResponseEntity<>("Category name cannot be empty", HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<>(categoryService.updateCategory(id, category), HttpStatus.OK);
        }
         catch(EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
         }
        catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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
