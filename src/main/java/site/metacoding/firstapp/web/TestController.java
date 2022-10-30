package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Product;
import site.metacoding.firstapp.domain.ProductDao;

@RequiredArgsConstructor
@Controller
public class TestController {

	private final ProductDao productDao;
	
	//1. view페이지를 컨트롤러로 연결한다. -> 연결확인
	//2. 해당 페이지의 기능을 구현한다.
	
	@PostMapping("/test")
	public String save() {
		return null;
		// 초기값은 null을 리턴해서 빨간 줄 안생기게 구현하기
	}

	// Model : Api의 RequestBody와 비슷하지만, Model은 view까지 값을 가져감
	@GetMapping("/test/product")
	public String findAll(Model model) {
		List<Product> productList = productDao.findAll();
		model.addAttribute("KongG", productList);
		return "product/list_test";
	}
	
	@GetMapping("/test/product/{productId}")
	public String findById(Model model, @PathVariable Integer productId) {
		Product productPS = productDao.findById(productId);
		model.addAttribute("HongG", productPS);
		return "product/detail_test";
	}
	
	@GetMapping("/test/product/edit/{productId}")
    public String updateForm(Model model, @PathVariable Integer productId, Product product) {
		Product productEdit = productDao.findById(productId);
		model.addAttribute("YeonG", productEdit);
		return "product/edit_test";
	}
	
	@PostMapping("/test/product/edit/{productId}")
	public String update(@PathVariable Integer productId, Product product) {
		Product productEdit = productDao.findById(productId);
		productEdit.update(product);
		productDao.update(productEdit);
		return "redirect:/";
	}
	
	@GetMapping("/test/product/add")
    public String insertForm() {
		return "product/add_test";
	}
	
	@PostMapping("/test/product/add")
    public String insert(Product product) {
		productDao.insert(product);
		return "redirect:/";
	}
	
	@PostMapping("/test/product/delete/{productId}")
	public String Delete(@PathVariable Integer productId) {
		productDao.deleteById(productId);
		return "redirect:/";
	}
}
