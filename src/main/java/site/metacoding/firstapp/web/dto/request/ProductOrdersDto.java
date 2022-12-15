package site.metacoding.firstapp.web.dto.request;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.domain.orders.Orders;

@Setter
@Getter
public class ProductOrdersDto {
    private Integer userId;
    private String orderUserName;
    private Integer productId;
    private String orderProductName;
    private Integer orderProductPrice;
    private Integer orderProductQty;

    // 주문자를 볼 수 없음. userId 정보 필요함.
    public Orders toEntity(Integer userId, String orderUserName) { // 주문자 정보 추가.

        // 앞에 this 붙이면 Dto에서 새로 입력한 정보 가져오는 것.
        // this 안 붙이면 원래 있던 데이터 가져오는 것!
        Orders orders = new Orders(userId, orderUserName, this.productId, this.orderProductName,
                this.orderProductPrice, this.orderProductQty);
        return orders;
    }
}
