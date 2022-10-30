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

	// Api RequestBody << model은 view까지 값을 가져감
	@GetMapping({"/product", "/"})
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
	
	@GetMapping("/product/edit/{productId}")
    public String updateForm(Model model, @PathVariable Integer productId, Product product) {
		Product productEdit = productDao.findById(productId);
		model.addAttribute("YeonG", productEdit);
		return "product/edit";
	}
	
	@PostMapping("/product/edit/{productId}")
	public String update(@PathVariable Integer productId, Product product) {
		Product productEdit = productDao.findById(productId);
		productEdit.update(product);
		productDao.update(productEdit);
		return "redirect:/";
	}
	
	@GetMapping("/product/add")
    public String insertForm() {
		return "product/add";
	}
	
	@PostMapping("/product/add")
    public String insert(Product product) {
		productDao.insert(product);
		return "redirect:/";
	}
	
	@PostMapping("/product/delete/{productId}")
	public String Delete(@PathVariable Integer productId) {
		productDao.deleteById(productId);
		return "redirect:/";
	}
}
