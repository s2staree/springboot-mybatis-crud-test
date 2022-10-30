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
public class ProductController {    
    
	private final ProductDao productDao;
	
	//1. view페이지를 컨트롤러로 연결한다. -> 연결확인
	//2. 해당 페이지의 기능을 구현한다.
	
	//[Create] Insert Form
	@GetMapping("/product/insert")
	public String 상품등록폼() {
		return "product/add";
	}
	
	//[Create] Insert
	@PostMapping("/product/insert")
	public String 상품등록(Product product) {
		productDao.insert(product);
		return "redirect:/";
	}
	
	//[Read] Selcet (findAll)
	@GetMapping({"/product", "/"})
	public String 상품목록(Model model){ // Model : Api의 RequestBody와 비슷하지만, Model은 view까지 값을 가져감
		List<Product> productList = productDao.findAll();
		model.addAttribute("list", productList);
		return "product/list";
	}
	
	//[Read] Selcet (findById)
	@GetMapping("/product/{productId}")
	public String 상품상세(@PathVariable Integer productId, Model model){
		Product productDetail = productDao.findById(productId);
		model.addAttribute("detail", productDetail);
		return "product/detail";
	}
	
	//[Update] Update Form
	@GetMapping("/product/{productId}/edit")
	public String 상품수정폼(Product product, Model model, @PathVariable Integer productId) {
		Product productEdit = productDao.findById(productId);
		model.addAttribute("edit", productEdit);
		return "product/edit";
	}
	
	//[Update] Update
	@PostMapping("/product/{productId}/edit")
	public String 상품수정(Product product, @PathVariable Integer productId) {
		Product productEdit = productDao.findById(productId);	// productId로 상품을 찾음
		productEdit.update(product);	// 찾은 상품을 수정
		productDao.update(productEdit);	// 수정된 내용 db에 저장
		return "redirect:/";
	}
	
	//[Delete] Delete
	@PostMapping("/product/{productId}/delete")
	public String 상품삭제(@PathVariable Integer productId) {
		productDao.deleteById(productId);
		return "redirect:/";
	}
	
}
