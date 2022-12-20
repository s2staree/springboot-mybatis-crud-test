package site.metacoding.firstapp.domain.orders;

import java.util.List;

public interface OrdersDao {

    public Orders findById(Integer orderId); // 해당 주문건 찾기

    public List<Orders> findAllById(Integer userId); // 해당 유저의 주문목록 보기

    public List<Orders> findAllByDate(); // 오늘의 주문목록 보기

    public List<Orders> findAll(); // 전체 주문목록 보기

    public void insert(Orders orders); // 주문 추가

    public void update(Orders orders);

    public void deleteById(Integer orderId); // 해당 주문삭제(구매취소)

}
