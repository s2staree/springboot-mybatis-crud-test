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
	
	@GetMapping("/api/product")
	public List<Product> findAll() {
		List<Product> productList = productDao.findAll();
		return productList;
	}
	
	@GetMapping("/api/product/{productId}")
	public Product findById(@PathVariable Integer productId) {
		Product productPS = productDao.findById(productId);
		return productPS;
	}
	
//	@PostMapping("/api/product/add")
//	public int insert(@RequestBody Product product) {
//		
//		// 1. db에 productName으로 등록된 상품이 있는지 유무 확인
//		Product productPS = productDao.findByName(product.getProductName());
//		if(productPS != null) { // 2. 상품이 있으면 다음 코드 실행
//			throw new RuntimeException("해당 상품 있음");
//		}
//		
//		// 3. 상품이 없으면 다음 코드 실행
//		int productInsert = productDao.insert(product);
//		return productInsert;
//	}
	
	@DeleteMapping("/api/product/{productId}/delete")
	public int deleteById(@PathVariable Integer productId) {
		
		// 1. db에 productId로 등록된 상품이 있는지 유무 확인
		Product productPS = productDao.findById(productId);

		if(productPS == null) { // 2. 상품이 없으면 다음 코드 실행
			throw new RuntimeException("해당 상품 없음");
			
		} // 3. 상품이 있으면 다음 코드 실행
		int productDelete = productDao.deleteById(productId);
		return productDelete;
	}
	
	@PutMapping("/api/product/edit")
	public int update(@RequestBody Product product) {
		
		// 1. db에 productId로 등록된 상품이 있는지 유무 확인
		Product productPS = productDao.findById(product.getProductId());
		if(productPS == null) { // 2. 상품이 없으면 다음 코드 실행
			throw new RuntimeException("해당 상품 없음");
		}
		// 3. 상품이 있으면 다음 코드 실행
		int productEdit = productDao.update(product);
		return productEdit;
	}
}
