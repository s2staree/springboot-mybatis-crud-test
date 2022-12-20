package site.metacoding.firstapp.web.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import site.metacoding.firstapp.domain.orders.Orders;

@ToString
@Setter
@Getter
public class ProductOrdersDto {
    // 아래처럼 이렇게 적혀있는 애들 아니면 나 일 안한대요 일 안한다고요
    private Integer orderId;
    private Integer userId;
    private String orderUserName; // 이름이 이렇게 되어야 한다니깐요?
    private Integer productId;
    private String orderProductName;
    private Integer orderProductPrice;
    private Integer orderProductQty;

    // 주문자를 볼 수 없음. userId 정보 필요함.
    public Orders toEntity(Integer userId, String orderUserName) { // 주문자 정보 추가.

        // 앞에 this 붙이면 Dto에서 새로 입력한 정보 가져오는 것.
        // this 안 붙이면 원래 있던 데이터 가져오는 것!
        Orders orders = new Orders(this.orderId, userId, orderUserName, this.productId, this.orderProductName,
                this.orderProductPrice, this.orderProductQty);
        return orders;
    }
}
