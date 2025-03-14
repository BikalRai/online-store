package raicod3.e_store.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import raicod3.e_store.product.dto.ProductRequestDTO;
import raicod3.e_store.product.dto.ProductResponseDTO;
import raicod3.e_store.product.service.ProductService;
import raicod3.e_store.utility.CustomException;

@RestController
@RequestMapping("/api/v1/product")
@Validated
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/create")
	public ResponseEntity<?> createProduct(
			@Valid @RequestBody ProductRequestDTO productRequestDto,
			BindingResult bindingResult
			) {
		if(bindingResult.hasErrors()) {
			List<String> errors = bindingResult.getAllErrors().stream()
					.map(error -> error.getDefaultMessage())
					.collect(Collectors.toList());
			
			Map<String, Object> response = new HashMap<>();
			response.put("errors", errors);
			return ResponseEntity.badRequest().body(response);
		}
		
		try {
			ProductResponseDTO productResponseDTO = productService.createProduct(productRequestDto);
			return new ResponseEntity<>(productResponseDTO, HttpStatus.CREATED);
		} catch (CustomException e) {
			Map<String, Object> response = new HashMap<>();
			response.put("error", e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllProducts(
			@RequestParam(required = false) String productName,
			@RequestParam(defaultValue = "10") int limit) {

		try {
			List<ProductResponseDTO> products = productService.getAllProdcuts(productName, limit);
			return new ResponseEntity<>(products, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
