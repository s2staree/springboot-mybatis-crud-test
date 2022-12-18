package site.metacoding.firstapp.domain.product;

import java.util.List;

import site.metacoding.firstapp.web.dto.request.ProductOrdersDto;

public interface ProductDao {

    public Product findById(Integer productId); // 상품Id찾기

    public List<Product> findAll(); // 상품목록보기

    public int insert(Product product); // 상품등록하기

    public int update(Product product); // 상품수정하기

    public int deleteById(Integer productId); // 상품삭제하기

    public Product findByProductName(String productName); // 상품명찾기

    public void productQtyUpdate(ProductOrdersDto productOrdersDto); // 상품재고수정하기

    public void productQtyRestore(ProductOrdersDto productOrdersDto); // 상품재고복원하기

}
