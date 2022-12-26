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
import site.metacoding.firstapp.web.dto.request.ProductOrdersDto;

@RequiredArgsConstructor // 밑의 코드에서 선언한 코드를 new해서 안 불러도 되게 해주는 어노테이션.
@Controller
public class OrdersController {

	private final ProductDao productDao; // 선언. @RequiredArgsConstructor 과 함께 씀.
	private final OrdersDao ordersDao;
	private final HttpSession session;

	// 관리자-전체주문목록보기
	@GetMapping({ "/admin/order/all", "/admin/order" })
	public String allOrderList(Model model) {
		List<Orders> ordersPS = ordersDao.findAll();
		model.addAttribute("orderList", ordersPS);
		return "admin/orders/all";
	}

	// 관리자-오늘주문목록보기
	@GetMapping("/admin/order/today")
	public String todayOrderList(Model model) {
		List<Orders> ordersPS = ordersDao.findAllByDate();
		model.addAttribute("orderList", ordersPS);
		return "admin/orders/today";
	}

	// 구매페이지 (손님-상품상세보기)
	@GetMapping("/product/{productId}")
	public String buyPage(@PathVariable Integer productId, Model model) {
		// @PathVariable: 매핑주소에서 id값을 찾을때 매개변수에 붙여줌.
		Product productPS = productDao.findById(productId);
		// 영속화 되어있는 값을 가져올 때 PS를 붙임.
		// 위에 있는 Product 타입의 애들 이름이랑 detail.머시기에 이름이랑 맞춰줘야함
		model.addAttribute("detail", productPS);
		// 뷰에게 통장이랑 현금뭉치 보내줄게! Product productPS면 Product 타입이니까 안에 이름대로 맞춰줘야돼!
		// productName=5만원 이라 치면 5만원 안 받으면 일을 안해 4만원 줘도 일안하고 6만원 줘도 일 안해 근데
		// productQty productName 이런식으로 있으면 덜주는건 괜찮은데 더 주는건 못참는 착한 노조라고 생각하자
		// 이름이 달라져도 안됨 5만원 주면 일하는 앤데 6만원 주면 안되는거야!
		return "user/product/detail";
	}

	// 손님-구매하기 : 해당 상품 재고 -1
	@PostMapping("/product/{productId}/buy")
	public String buy(@PathVariable Integer productId, ProductOrdersDto productOrdersDto) {
		// 나 ProductOrdersDto 타입의 애들거 안받으면 일 안할거야 더줘도 안하고 덜주면 일할게
		// 나 productOrdersDto 안에 있는 애들 이름만 받을거야 jsp 파일에서 name을 붙여줘야돼
		// form은 name이고 ajax 에이작스면 id를 붙여줘야 돼
		// 위에 있는 이름이 없는건 되지만 더 추가되면 터진다
		// 안터지고 결과만 보고 싶으면 db에 들어가서 null 허용을 해줘야 한다

		System.out.println(productOrdersDto); // Dto에서 뭘 받는지 확인하기위한 디버그코드.

		// 아래 코드가 디버그코드야 이걸 꼭 참고하도록 해
		// jsp 파일로 가면 value는 돈 이니까 이 돈 안주면 안됨 돈이 아니라 통장이라 생각해도 됨.
		// name은 카드 카드를 이름에 맞게 적어주도록 하자
		// form 태그 범위 안에 있어야 됨 name들이!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// <button type="submit">구매하기</button> submit이 있어야 함!!!!!!!!!!!!!!
		// input hidden 콤보를 사용하도록 하자! 그러면 유용함 꿀팁스
		System.out.println("디버그 주문상품명" + productOrdersDto.getOrderProductName()); // 주문상품
		System.out.println("디버그 주문가격" + productOrdersDto.getOrderProductPrice()); // 주문가격
		System.out.println("디버그 주문수량" + productOrdersDto.getOrderProductQty()); // 주문수량
		// 디버깅 코드 잘 기억해야함!
		// .get 을 잘 활용하자! getter 달려 있으면 다 가져올 수 있음
		// .set은 변경시키겠다는 의미!

		// 구매한 유저의 로그인 정보를 가져옴.
		User principal = (User) session.getAttribute("principal"); // 로그인 정보 가져오는 코드! 없으면 터짐

		if (principal == null) {
			// 이거 적으면 안터지고 로그인 페이지로 이동, 인터셉터는 나중에 배우자 코드 복붙하면 됨, JWT도 공부해보자!
			// 이거 쓰면 DB에서 select 안해도 되고 인증 가능
			// authorization 써서 토큰 정보 가져오면 페이지 방문할 때 토큰 없으면 돌려보냄, 페이로드 값 가져옴,
			// 시그니처가 다른 2개 조합해서 만든건데 이걸로 만듦
			// JWT 목표는 암호화가 아니고 인증이 목표임
			// 디코딩했을 때 비밀번호가 똑같이 암호화되는지 확인하고 들여보내주는데
			// 제한시간도 걸 수 있고 필터를 사용해서 만들 수도 있고 컨트롤러에서 바로 토큰생성하는 코드 만들어도 됨!!
			return "redirect:/login";
		}

		// 상품Id로 해당 상품 찾아서 상품DB 담음.
		Product productPS = productDao.findById(productId);
		System.out.println("디버그 주문전 재고 : " + productPS.getProductQty()); // 재고

		// 잘못된 수량 주문 막기. (상품DB 재고 - 주문수량 < 0)
		if (productPS.getProductQty() - productOrdersDto.getOrderProductQty() < 0) {
			return "redirect:/product/{productId}"; // 안돼요 싫어요 수량이 안맞아요
		}
		// if문이 참일 경우: 잘못된 수량 (상품수량<주문수량) 이므로 if문 내부의 return까지만 실행!
		// if문이 거짓일 경우: 제대로 된 수량 (상품수량>주문수량) 이므로 다음 코드부터 실행!

		// 상품DB에 재고 수정.
		int result = productDao.productQtyUpdate(productOrdersDto);

		System.out.println("업데이트 상태 : " + result);
		Product productPS22 = productDao.findById(productId);
		System.out.println("디버그 주문이후재고:" + productPS22.getProductQty());

		// 주문DB에 주문 추가.
		ordersDao.insert(productOrdersDto.toEntity(principal.getUserId(), principal.getUserName()));
		return "redirect:/";

	}

	// 손님-구매목록(주문목록)페이지
	@GetMapping("/product/order")
	// session으로 유저 로그인 정보를 가져오기 때문에 매핑주소에 userId를 받을 필요없음. 오히려 넣으면 터짐.
	public String buyList(Model model) {

		User principal = (User) session.getAttribute("principal"); // 로그인 정보 가져오는 코드!

		if (principal == null) { // 로그인 정보가 없으면,
			return "redirect:/login"; // 로그인 페이지로 돌려보내기!
		}

		List<Orders> ordersPS = ordersDao.findAllById(principal.getUserId());
		// 로그인 정보를 가져와서 주문목록보기 기능에 넣고 List<Orders> 타입의 ordersPS에 담아놓기.

		model.addAttribute("orderList", ordersPS);
		// ordersList를 jsp의 forEach문의 items에 적고 var의 .뒤의 값들을 참조해서(ordersPS에 맞춰 적어야 함)
		// model에 담고 뷰에 뿌림!
		// List<Orders> ordersPS면 List<Orders> 타입이니까 jsp의 forEach문의 ${} 안에 Orders 엔티티
		// 이름대로 맞춰줘야 됨!

		return "user/orders/list";

	}

	// 구매취소(주문철회)
	@PostMapping("/product/{productId}/order/{orderId}/cancel")
	// 매퍼에서 조인으로 연결된 Id값이 있을 때, Id값을 못 찾아온다면 매핑주소에 추가해주면 해결될 것!
	public String buyCancel(@PathVariable Integer productId, @PathVariable Integer orderId,
			ProductOrdersDto productOrdersDto) {

		User principal = (User) session.getAttribute("principal"); // 로그인 정보 가져오는 코드!

		if (principal == null) { // 로그인 정보가 없으면,
			return "redirect:/login"; // 로그인 페이지로 돌려보내기!
		}

		// 주문Id로 해당 주문 찾아서 주문DB 담음.
		Orders ordersPS = ordersDao.findById(orderId);
		System.out.println("디버그: " + orderId);

		// 주문DB에 해당 주문건 삭제
		ordersDao.deleteById(ordersPS.getOrderId());
		System.out.println("디버그: " + productOrdersDto.getProductId());

		// 상품DB에 해당 상품 재고 복원
		productDao.productQtyRestore(productOrdersDto);

		if (principal.getUserRole().equals("admin")) { // 인증 정보에 userRole이 "admin"이면,
			return "redirect:/admin/product/order"; // 관리자모드의 주문목록 페이지로 이동.
		}

		return "redirect:/product/order";

	}

}
