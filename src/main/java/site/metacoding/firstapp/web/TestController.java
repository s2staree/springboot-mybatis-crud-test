package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Product;
import site.metacoding.firstapp.domain.ProductDao;

@RequiredArgsConstructor
@Controller
public class TestController {

	private final ProductDao productDao;

	// Api requestBody << model은 view까지 값을 가져감
	@GetMapping("/product")
	public String findAll(Model model) {
		List<Product> productList = productDao.findAll();
		model.addAttribute("KongG", productList);
		return "product/list";
	}
	
	@GetMapping("/product/{productId}")
	public String findById(Model model, @PathVariable Integer productId) {
		Product productPS = productDao.findById(productId);
		model.addAttribute("HongG", productPS);
		return "product/detail";
	}
}
