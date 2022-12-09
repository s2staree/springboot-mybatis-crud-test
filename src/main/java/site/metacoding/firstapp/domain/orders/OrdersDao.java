package site.metacoding.firstapp.domain.orders;

import java.util.List;

public interface OrdersDao {

    public void findById(Integer orderId);

    public List<Orders> findAll();

    public void insert(Orders orders);

    public void update(Orders orders);

    public void deleteById(Integer ordersId);

}