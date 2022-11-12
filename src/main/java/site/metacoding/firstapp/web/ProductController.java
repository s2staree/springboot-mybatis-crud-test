package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Product;
import site.metacoding.firstapp.domain.ProductDao;

@RequiredArgsConstructor	// 밑의 코드에서 선언한 코드를 new해서 안 불러도 되게 해주는 어노테이션.
@Controller
public class ProductController {
	
	private final ProductDao productDao;	// 선언. @RequiredArgsConstructor 과 함께 씀.
    
    @GetMapping({"/product/{productId}", "/product/{productId}/detail"})
    public String findById() {
        return "product/detail";
    }
    
	// 상품목록보기
    @GetMapping({"/product", "/"})
    public String findAll(Model model) { // Model: 페이지(jsp) view로 가져오기 위해서 사용. Request(요청)같은 기능.
    	List<Product> productPS = productDao.findAll();
    	model.addAttribute("list", productPS);
        return "product/list";
    }
    
    // 상품등록하기 Form
    @GetMapping("/product/add")
    public String insertForm() {
        return "product/add";
    }
    
    // 상품등록하기
    @PostMapping("/product/add")
    public String insert(Product product) {
    	productDao.insert(product);
        return "product/add";
    }
    
    @GetMapping("/product/{productId}/edit")
    public String updateForm() {
        return "product/edit";
    }
    
    @PostMapping("/product/{productId}/edit")
    public String update() {
        return "product/edit";
    }
    
    @PostMapping("/product/{productId}/delete")
    public String deleteById() {
        return "redirect:/";
    }
}
