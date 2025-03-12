package raicod3.e_store.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import raicod3.e_store.product.dto.ProductRequestDTO;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	@PostMapping("/create")
	public ResponseEntity<?> createProduct(@RequestBody ProductRequestDTO productDto) {
		return null;
	}

}
