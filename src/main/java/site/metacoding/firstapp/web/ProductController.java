package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    
    @GetMapping({"/product/{productId}", "/product/{productId}/detail"})
    public String findById() {
        return "product/detail";
    }
    
    @GetMapping({"/product", "/"})
    public String findAll() {
        return "product/list";
    }
    
    @GetMapping("/product/add")
    public String insertForm() {
        return "product/add";
    }
    
    @PostMapping("/product/add")
    public String insert() {
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
