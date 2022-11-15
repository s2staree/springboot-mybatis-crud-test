package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	// 상품상세보기
    @GetMapping({"/product/{productId}", "/product/{productId}/detail"})
    public String findById() {
        return "product/detail";
    }

    // 상품목록보기
    @GetMapping({"/product", "/"})
    public String findAll() {
        return "product/list";
    }

    // 상품등록하기 Form
    @GetMapping("/product/add")
    public String insertForm() {
        return "product/add";
    }
    
    // 상품수정하기 Form
    @GetMapping("/product/{productId}/edit")
    public String updateForm() {
        return "product/edit";
    }
    
}