package site.metacoding.firstapp.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.product.Product;
import site.metacoding.firstapp.domain.product.ProductDao;
import site.metacoding.firstapp.domain.user.User;
import site.metacoding.firstapp.domain.user.UserDao;
import site.metacoding.firstapp.web.dto.request.UserLoginDto;

@RequiredArgsConstructor // 밑의 코드에서 선언한 코드를 new해서 안 불러도 되게 해주는 어노테이션.
@Controller
public class UserController {

	private final ProductDao productDao; // 선언. @RequiredArgsConstructor 과 함께 씀.
	private final UserDao userDao;
	private final HttpSession session;

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

	// 회원가입 Form
	@GetMapping("/join")
	public String joinForm() {
		return "user/account/join";
	}

	// 회원가입
	@PostMapping("/join")
	public String join(User user) {
		userDao.join(user);
		return "redirect:/";
	}

	// 로그인 Form
	@GetMapping("/login")
	public String loginForm() {
		return "user/account/login";
	}

	// 로그인
	@PostMapping("login") // 로그인만 예외로 select-post매핑!
	public String login(UserLoginDto userLoginDto) {

		User userPS = userDao.login(userLoginDto); // login할 때 적힌 데이터를 담음.

		if (userPS != null) { // user 엔티티에 해당 데이터가 있으면
			session.setAttribute("principal", userPS); // 인증
			return "redirect:/"; // 홈으로 이동.
		} else { // 없으면
			return "redirect:/login"; // 다시 로그인 페이지.
		}

	}

}
