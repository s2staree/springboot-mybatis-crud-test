package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.product.Product;
import site.metacoding.firstapp.domain.product.ProductDao;
import site.metacoding.firstapp.service.ProductService;
import site.metacoding.firstapp.web.dto.response.CMRespDto;

@RequiredArgsConstructor // 밑의 코드에서 선언한 코드를 new해서 안 불러도 되게 해주는 어노테이션.
@Controller
public class ProductController {

	private final ProductDao productDao; // 선언. @RequiredArgsConstructor 과 함께 씀.
	private final ProductService productService;

	// 메인페이지 (손님-상품목록보기)
	@GetMapping({ "/product", "/home", "/" })
	public String homePage(Model model) { // Model model: 페이지(jsp) view로 가져오기 위해서 사용. Request(요청)같은 기능.
		List<Product> productPS = productDao.findAll();
		model.addAttribute("list", productPS);
		return "user/product/list";
	}

	// 관리자-상품목록보기
	@GetMapping({ "/admin/product", "/admin" })
	public String findAll(Model model) { // Model model: 페이지(jsp) view로 가져오기 위해서 사용. Request(요청)같은 기능.
		List<Product> productPS = productDao.findAll();
		model.addAttribute("list", productPS);
		return "admin/product/list";
	}

	// 관리자-상품상세보기
	@GetMapping({ "/admin/product/{productId}", "/admin/product/{productId}/detail" })
	public String findById(@PathVariable Integer productId, Model model) { // @PathVariable: 매핑주소에서 id값을 찾을때 매개변수에 붙여줌.
		Product productPS = productDao.findById(productId); // 영속화 되어있는 값을 가져올 때 PS를 붙임.
		model.addAttribute("detail", productPS);
		return "admin/product/detail";
	}

	// 관리자-상품등록하기 Form
	@GetMapping("/admin/product/add")
	public String insertForm() {
		return "admin/product/add";
	}

	// 관리자-상품등록하기
	@PostMapping("/admin/product/add")
	public @ResponseBody CMRespDto<?> insert(@RequestBody Product product) {
		productDao.insert(product); // 상품등록후 db에 저장
		return new CMRespDto<>(1, "상품등록성공", null); // 1: 성공 / -1: 실패
	}

	// 상품명 중복확인
	// http://localhost:8080/api/admin/product/isProductNameSameCheck?productName=딸기
	@GetMapping("/api/admin/product/isProductNameSameCheck")
	public @ResponseBody CMRespDto<Boolean> isProductNameSameCheck(String productName) {
		boolean isSame = productService.상품명중복확인(productName);
		return new CMRespDto<>(1, "성공", isSame);
	}

	// 관리자-상품수정하기 Form
	@GetMapping("/admin/product/{productId}/edit")
	public String updateForm(@PathVariable Integer productId, Model model) {
		Product productPS = productDao.findById(productId);
		model.addAttribute("edit", productPS);
		return "admin/product/edit";
	}

	// 관리자-상품수정하기
	@PostMapping("/admin/product/{productId}/edit") // 위 Form 코드의 매핑주소와 통일해야 함.
	public String update(Product product) { // 위 Form 코드에서 id값을 이미 받아왔기 때문에 @PathVariable 안 붙여도 됨.
		productDao.update(product);
		return "redirect:/admin/product";
	}

	// 관리자-상품삭제하기
	@PostMapping("/admin/product/{productId}/delete")
	public String deleteById(@PathVariable Integer productId) {
		productDao.deleteById(productId);
		return "redirect:/admin/product";
	}

}