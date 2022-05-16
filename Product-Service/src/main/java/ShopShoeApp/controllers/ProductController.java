package ShopShoeApp.controllers;

import ShopShoeApp.entity.ProductEntity;
import ShopShoeApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping()
	public List<ProductEntity> getAllProduct() {
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<ProductEntity> getProductById(@PathVariable(value = "id") Long id) {
		return productRepository.findById(id);
	}
	
	@PostMapping()
	public String crateProduct(@RequestBody ProductEntity accountEntity){
		productRepository.save(accountEntity);
		return "Create successful";
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable long id) {
		try {
			ProductEntity account = productRepository.getById(id);
			productRepository.delete(account);
			return "Delete successful";
		} catch (Exception e) {
			return "Error";
		}	
	}
}
