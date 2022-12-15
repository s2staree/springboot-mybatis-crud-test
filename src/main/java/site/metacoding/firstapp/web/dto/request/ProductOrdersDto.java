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
    public Orders toEntity(Integer userId) {
        Orders orders = new Orders(userId, this.orderUserName, this.productId, this.orderProductName,
                this.orderProductPrice, this.orderProductQty);
        return orders;
    }
}
