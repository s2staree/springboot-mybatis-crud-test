package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Product;
import site.metacoding.firstapp.domain.ProductDao;

// 메모리에 안 띄운다? <사용할 수 없음(없는 객체라고 인식되서)
@RequiredArgsConstructor	// final을 알아서 new시켜줌(메모리에 띄워줌) 
@RestController	// 데이터를 보는 거
public class TestApiController {
	
	// 기능은 무조건 여기다 올려두고 사용하셈
	// 쌤한테 한번 더 짚어달라구 햇
	private final ProductDao productDao;
	
	// RequestBody << 요청한 몸체 (규칙 : 유저한테 받은 값을 가져오려면 붙여야 함)
	// 사용자가 입력한 값이 들어가 있음
	// 사용자가 입력한 product라는 객체
	@PostMapping("/test/api/product")
	public int saveTest(@RequestBody Product product) {
		// dao의 insert호출 (사용자가 입력한 객체)
		int productPS = productDao.insert(product);
		return productPS;
	}
	
	//localhost/test/api/product/1
	// 규칙 PathVariable < 주소창에 있는 {}사이에 끼이는 값을 매개변수에 입혀줌
	@GetMapping("/test/api/product/{productId}")
	public Product findByIdTest(@PathVariable Integer productId) {
		Product productPS = productDao.findById(productId);
		return productPS;
		//return "product/main" <<view에 꽂은것
	}
	
	@GetMapping("/test/api/product")
	public List<Product> findAll(){
		List<Product> productList = productDao.findAll();
		return productList;
	}
	
	@DeleteMapping("/test/api/product/{productId}/delete")
    public int delete(@PathVariable Integer productId) {
		int productDelete = productDao.deleteById(productId);
		return productDelete;
	}
	
	/*
	// put -> id로 찾아서 id로 찾은 객체의 값을 변경함 (get+post개념)
	// get -> id를 사용해서 해당 id의 값을 가져옴
	// post -> 객체에 값을 담아서 보냄 (db로~)
	@PutMapping("/test/api/product/{productId}/edit")
	public int update(@PathVariable Integer productId, @RequestBody Product product) {
		int productEdit = productDao.update(product);
		return productEdit;
	}
	*/
	
	// mapper(product.xml)의 update에 productId를 찾아가는 쿼리가 이미 짜져 있어서
	// 굳이 PutMapping 주소에 {productId} 넣을 필요 없음 -> @PathVariable 쓸 필요 없음!
	@PutMapping("/test/api/product")
	public int update(@RequestBody Product product) {
		int productEdit = productDao.update(product);
		return productEdit;
	}
}
