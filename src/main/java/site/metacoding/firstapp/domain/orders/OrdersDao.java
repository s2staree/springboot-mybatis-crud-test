package site.metacoding.firstapp.domain.orders;

import java.util.List;

public interface OrdersDao {

    public void findById(Integer orderId);

    public List<Orders> findAll(Integer userId); // 해당 유저의 주문목록 보기

    public void insert(Orders orders); // 주문 추가

    public void update(Orders orders);

    public void deleteById(Integer orderId); // 해당 주문삭제(구매취소)

}
