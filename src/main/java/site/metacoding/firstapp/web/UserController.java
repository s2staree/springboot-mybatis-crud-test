package site.metacoding.firstapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.user.User;
import site.metacoding.firstapp.domain.user.UserDao;
import site.metacoding.firstapp.web.dto.request.UserJoinDto;
import site.metacoding.firstapp.web.dto.request.UserLoginDto;

@RequiredArgsConstructor // 밑의 코드에서 선언한 코드를 new해서 안 불러도 되게 해주는 어노테이션.
@Controller
public class UserController {

	private final UserDao userDao; // 선언. @RequiredArgsConstructor 과 함께 씀.
	private final HttpSession session; // 인증시 필요한 코드. 스프링이 서버시작시에 IoC 컨테이너에 보관함.

	// 회원가입 Form
	@GetMapping("/join")
	public String joinForm() {
		return "user/account/join";
	}

	// 회원가입
	@PostMapping("/join")
	public String join(UserJoinDto userJoinDto) {
		userDao.join(userJoinDto);
		return "redirect:/";
	}

	// 로그인 Form
	@GetMapping("/login")
	public String loginForm() {
		return "user/account/login";
	}

	// 로그인
	@PostMapping("/login") // 로그인만 예외로 select-post매핑!
	public String login(UserLoginDto userLoginDto) {

		User userPS = userDao.login(userLoginDto); // login할 때 적힌 데이터를 담음.

		if (userPS != null) { // user 엔티티에 해당 데이터가 있으면
			session.setAttribute("principal", userPS); // 인증. (통째로 외우자.)
			return "redirect:/"; // 홈으로 이동.
		} else { // 없으면
			return "redirect:/login"; // 다시 로그인 페이지.
		}

	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout() {
		session.invalidate(); // 해당 사용자의 키 값을 날리는 것. (통째로 외우면 됨.)
		return "redirect:/";
	}

}
