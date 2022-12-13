package site.metacoding.firstapp.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.orders.Orders;
import site.metacoding.firstapp.domain.orders.OrdersDao;
import site.metacoding.firstapp.domain.product.Product;
import site.metacoding.firstapp.domain.product.ProductDao;
import site.metacoding.firstapp.domain.user.User;

@RequiredArgsConstructor // 밑의 코드에서 선언한 코드를 new해서 안 불러도 되게 해주는 어노테이션.
@Controller
public class OrdersController {

	private final ProductDao productDao; // 선언. @RequiredArgsConstructor 과 함께 씀.
	private final OrdersDao ordersDao;
	private final HttpSession session;

	// 메인페이지 (유저-상품목록보기)
	@GetMapping({ "/product", "/home", "/" })
	public String homePage(Model model) { // Model model: 페이지(jsp) view로 가져오기 위해서 사용. Request(요청)같은 기능.
		List<Product> productPS = productDao.findAll();
		model.addAttribute("list", productPS);
		return "user/product/list";
	}

	// 구매페이지 (유저-상품상세보기)
	@GetMapping("/product/{productId}")
	public String buyPage(@PathVariable Integer productId, Model model) { // @PathVariable: 매핑주소에서 id값을 찾을때 매개변수에 붙여줌.
		Product productPS = productDao.findById(productId); // 영속화 되어있는 값을 가져올 때 PS를 붙임.
		// 위에 있는 Product 타입의 애들 이름이랑 detail.머시기에 이름이랑 맞춰줘야함
		model.addAttribute("detail", productPS); // 뷰에게 통장이랑 현금뭉치 보내줄게! Product productPS면 Product 타입이니까 안에 이름대로 맞춰줘야돼!
													// productName=5만원 이라 치면 5만원 안 받으면 일을 안해 4만원 줘도 일안하고 6만원 줘도 일 안해 근데
													// productQty productName 이런식으로 있으면 덜주는건 괜찮은데 더 주는건 못참는 착한 노조라고 생각하자
													// 이름이 달라져도 안됨 5만원 주면 일하는 앤데 6만원 주면 안되는거야!
		return "user/product/detail";
	}

	// 구매하기 (해당 상품 재고 -1)
	@PostMapping("/product/{productId}/buy")
	public String buy(@PathVariable Integer productId, Orders orders) { // 나 Orders 타입의 애들거 안받으면 일 안할거야 더줘도 안하고 덜주면 일할게
		// 디버깅 코드 잘 기억해야함!
		// .get 을 잘 활용하자! getter 달려 있으면 다 가져올 수 있음
		// .set은 변경시키겠다는 의미!
		System.out.println("디버그 주문상품명" + orders.getOrderProductName()); // 주문상품
		System.out.println("디버그 주문상품명" + orders.getOrderProductPrice()); // 주문가격
		System.out.println("디버그 주문상품명" + orders.getOrderProductQty()); // 주문수량

		// 구매한 유저의 로그인 정보를 가져옴.
		User principal = (User) session.getAttribute("principal"); // 로그인 정보 가져오는 코드! 없으면 터짐

		// 상품Id로 해당 상품 찾아서 상품DB 담음.
		Product productPS = productDao.findById(productId);

		// 주문DB에 주문 추가.
		ordersDao.insert(orders); // orders.getUserId() == Integer userId

		return "redirect:/";

	}

}