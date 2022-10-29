package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Product;
import site.metacoding.firstapp.domain.ProductDao;

@RequiredArgsConstructor
@RestController
public class ProductApiController {
	
	private final ProductDao productDao;
	
	@GetMapping("/product")
	public List<Product> findAll() {
		List<Product> productList = productDao.findAll();
		return productList;
	}
	
	@GetMapping("/product/{productId}")
	public Product findById(@PathVariable Integer productId) {
		Product productPS = productDao.findById(productId);
		return productPS;
	}
	
	@PostMapping("/product/insert")
	public int insert(@RequestBody Product product) {
		int productInsert = productDao.insert(product);
		return productInsert;
	}
	
	@DeleteMapping("/product/{productId}/delete")
	public int deleteById(@PathVariable Integer productId) {
		int productDelete = productDao.deleteById(productId);
		return productDelete;
	}
	
	@PutMapping("/product/edit")
	public int update(@RequestBody Product product) {
		int productEdit = productDao.update(product);
		return productEdit;
	}
}
