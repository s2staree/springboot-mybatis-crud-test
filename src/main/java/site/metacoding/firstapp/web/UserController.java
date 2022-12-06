package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.product.Product;
import site.metacoding.firstapp.domain.product.ProductDao;

@RequiredArgsConstructor // 밑의 코드에서 선언한 코드를 new해서 안 불러도 되게 해주는 어노테이션.
@Controller
public class UserController {

	private final ProductDao productDao; // 선언. @RequiredArgsConstructor 과 함께 씀.

	// 메인페이지 (유저상품목록보기)
	@GetMapping({ "/home", "/" })
	public String homePage(Model model) { // Model model: 페이지(jsp) view로 가져오기 위해서 사용. Request(요청)같은 기능.
		List<Product> productPS = productDao.findAll();
		model.addAttribute("list", productPS);
		return "user/product/list";
	}

	// 구매페이지 (유저상품상세보기)
	@GetMapping("/product/{productId}")
	public String buyPage() {
		return "user/product/detail";
	}

	// 로그인 Form
	@GetMapping("/login")
	public String loginForm() {
		return "user/account/login";
	}

	// 회원가입 Form
	@GetMapping("/join")
	public String joinForm() {
		return "user/account/join";
	}

}