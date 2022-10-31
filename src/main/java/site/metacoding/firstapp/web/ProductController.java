package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	
	/*
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
	*/
	
	//[Delete] Delete
	@PostMapping("/product/{productId}/delete")
	public String 상품삭제(@PathVariable Integer productId) {
		productDao.deleteById(productId);
		return "redirect:/";
	}
	
	
	// Model은 view까지 값을 가져감
	// PathVariable은 주소창에 {}안에 있는 데이터를 가져오는 애
	// 만약에 String이면 String값, Integer면 Integer값
	// PS가 붙으면 영속화 되어 있는 데이터. (db에) 영구적으로 남아있는 데이터. 각서를 쓴 데이터
	// 실제로 존재하는 값. 안 바뀜. 약속.
	// DAO는 기능을 적어서 db랑 통신하는 애.
	// findById로 상품의 정보를 가져옴.
	// model로 jsp에 값을 입힘.
	// 상품수정페이지로 리턴.
	
	/*
	// 1. 수정하기 페이지 호출
	@GetMapping("/update/{productId}")
	public String updateForm(Model model, @PathVariable Integer productId) {
		Product productPS = productDao.findById(productId);
		model.addAttribute("productPS", productPS);
		return "/product/edit";
	}
	
	// 2. 수정하기
	@PutMapping("/update/{productId}")
	public String update(Product product, @PathVariable Integer productId) {
		productDao.update(product);
		return "redirect:/";
	}
	// productDao.update(product)할때 product의 출처를 표기하기 위해
	// public String update()안에 Product product를 넣는다.
	
	// public String update()안의 Product product는 유저에게 받은 값을 임시로 가지고 있음
	
	// 해당 productId
	*/
	
	//[Update] Update Form
	@GetMapping("/product/{productId}/edit")
	public String 상품수정폼(Model model, @PathVariable Integer productId) {
		Product productPS = productDao.findById(productId);
		model.addAttribute("edit", productPS);
		return "product/edit";
	}
	
	//[Update] Update
	@PostMapping("/product/{productId}/edit")
	public String 상품수정(Product product, @PathVariable Integer productId) {
		productDao.update(product);	// 수정된 내용 db에 저장
		return "redirect:/";
	}
	
}
