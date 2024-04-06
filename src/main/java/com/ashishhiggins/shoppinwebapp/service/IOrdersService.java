package com.ashishhiggins.shoppinwebapp.service;

import com.ashishhiggins.shoppinwebapp.dto.OrdersDto;
import com.ashishhiggins.shoppinwebapp.entity.Orders;


import java.util.List;
import java.util.Optional;

public interface IOrdersService {

    Orders fetchOrderById(Long orderId);

    Orders createOrder(Long userId, Long produuctId, int quantity, String coupon);

    List<Orders> fetchAllOrdersByUserId(Long userId);

    Optional<OrdersDto> findByUserUserIdAndOrderId(Long userId, Long orderId);

}
