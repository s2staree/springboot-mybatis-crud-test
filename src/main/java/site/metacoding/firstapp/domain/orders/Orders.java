package site.metacoding.firstapp.domain.orders;

import java.sql.Timestamp;

import lombok.Getter;

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
}
