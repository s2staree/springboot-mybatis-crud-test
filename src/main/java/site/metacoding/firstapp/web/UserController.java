package site.metacoding.firstapp.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.user.User;
import site.metacoding.firstapp.domain.user.UserDao;
import site.metacoding.firstapp.service.UserService;
import site.metacoding.firstapp.web.dto.request.UserJoinDto;
import site.metacoding.firstapp.web.dto.request.UserLoginDto;
import site.metacoding.firstapp.web.dto.response.CMRespDto;

@RequiredArgsConstructor // 밑의 코드에서 선언한 코드를 new해서 안 불러도 되게 해주는 어노테이션.
@Controller
public class UserController {

	private final UserDao userDao; // 선언. @RequiredArgsConstructor 과 함께 씀.
	private final UserService userService;
	private final HttpSession session; // 인증시 필요한 코드. 스프링이 서버시작시에 IoC 컨테이너에 보관함.

	// 관리자-전체회원목록보기
	@GetMapping("/admin/user")
	public String userList(Model model) {
		List<User> userPS = userDao.findAll();
		model.addAttribute("userList", userPS);
		return "admin/account/users";
	}

	// 관리자-손님회원목록보기
	@GetMapping("/admin/user/customer")
	public String customerList(Model model, String userRole) {
		List<User> userPS = userDao.findByRole(userRole);
		model.addAttribute("customerList", userPS);
		return "admin/account/customers";
	}

	// 회원정보수정 Form
	@GetMapping("/admin/account/{userId}/edit")
	public String accountEditForm(@PathVariable Integer userId, Model model) {

		// 회원Id를 찾아서 해당 회원정보를 userPS에 담기
		User userPS = userDao.findById(userId);

		// 해당 회원정보를 model에 담아서 뷰에 띄우기!
		model.addAttribute("accountEdit", userPS);

		return "admin/account/edit";
	}

	// 회원정보수정
	@PostMapping("/admin/account/{userId}/edit") // 위 Form 코드의 매핑주소와 통일해야 함
	public String accountEdit(User user) { // 위 Form 코드에서 id값을 이미 받아왔기 때문에 @PathVariable 안 붙여도 됨

		// 회원정보 DB 변경!
		userDao.update(user);

		return "redirect:/admin/user";
	}

	// 회원계정삭제
	@PostMapping("admin/account/{userId}/delete")
	public String accountDelete(@PathVariable Integer userId) {
		userDao.deleteById(userId);
		return "redirect:/admin/user";
	}

	// 회원가입 Form
	@GetMapping("/join")
	public String joinForm() {
		return "user/account/join";
	}

	// 회원가입
	@PostMapping("/join")
	public @ResponseBody CMRespDto<?> join(@RequestBody UserJoinDto userJoinDto) {
		userDao.join(userJoinDto);
		return new CMRespDto<>(1, "회원가입성공", null); // 1: 성공 / -1: 실패
	}

	// 아이디 중복확인
	// http://localhost:8080/api/user/account/isUserNameSameCheck?userName=user
	@GetMapping("/api/user/account/isUserNameSameCheck")
	public @ResponseBody CMRespDto<Boolean> isUserNameSameCheck(String userName) {
		boolean isSame = userService.아이디중복확인(userName);
		return new CMRespDto<>(1, "성공", isSame);
	}

	// 로그인 Form
	@GetMapping("/login")
	public String loginForm() {
		return "user/account/login";
	}

	// 로그인
	@PostMapping("/login") // 로그인만 예외로 select-post매핑!
	public String login(UserLoginDto userLoginDto) {

		User principal = userDao.login(userLoginDto); // login할 때 적힌 데이터를 담음.
		// PS를 붙이는 것: 이 값을 그대로 이동하겠어요~! 할 때 사용!
		// principal: 키값(세션)을 보통 "principal"이라고 정함! (= 인증된 유저)
		// session에 principal값이 있으면 로그인 된 것이고, 없으면 안된 것으로 알면 됨.

		if (principal == null) { // user 엔티티에 해당 데이터가 없으면,

			return "redirect:/login"; // 다시 로그인 페이지.

		}

		if (principal.getUserRole().equals("admin")) {
			// 인증 정보에 userRole이 "admin"이면,
			// equals는 하나의 객체가 "admin"이라는 객체와 일치한다는 뜻.
			// == 는 주소가 일치한다는 것을 의미함.
			// 이 상황에서는 .equals()를 사용하는 것이 알맞음!

			session.setAttribute("principal", principal); // 인증.

			return "redirect:/admin"; // 관리자모드로 이동.

		}

		// (위의 if문 모두 false일 경우 다음 코드 실행)
		// 인증 정보에 userRole이 나머지(customer)이면,

		session.setAttribute("principal", principal); // 인증.

		return "redirect:/"; // (인증 후의) 메인페이지로 이동.

	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout() {
		session.invalidate(); // 해당 사용자의 키 값을 날리는 것. (통째로 외우면 됨.)
		return "redirect:/";
	}

}
