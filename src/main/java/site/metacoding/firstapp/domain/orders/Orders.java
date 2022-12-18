package site.metacoding.firstapp.domain.orders;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // 생성자를 만들면 꼭 같이 붙여줘야 함!
@Setter
@Getter
public class Orders {
    private Integer orderId;
    private Integer userId;
    private String orderUserName;
    private Integer productId;
    private String orderProductName;
    private Integer orderProductPrice;
    private Integer orderProductQty;
    private Timestamp createdAt;

    // 클래스 외부에서 변수를 마음대로 접근할 수 있도록 생성자 만들기
    public Orders(Integer orderId, Integer userId, String orderUserName, Integer productId, String orderProductName,
            Integer orderProductPrice, Integer orderProductQty) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderUserName = orderUserName;
        this.productId = productId;
        this.orderProductName = orderProductName;
        this.orderProductPrice = orderProductPrice;
        this.orderProductQty = orderProductQty;
    }

}
