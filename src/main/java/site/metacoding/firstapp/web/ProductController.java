package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.ProductDao;

@RequiredArgsConstructor
@Controller
public class ProductController {    
    
	private final ProductDao productDao;
	
	//1. view페이지를 컨트롤러로 연결한다 -> 연결확인
	//2. 해당 페이지의 기능을 구현한다.
	
	//1) insert
	@PostMapping("/board")
	public String save() {
		return null;
		// 초기값은 null을 리턴해서 빨간 줄 안생기게 구현하기
	}
}
