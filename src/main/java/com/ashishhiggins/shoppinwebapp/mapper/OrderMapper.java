package com.ashishhiggins.shoppinwebapp.mapper;

import com.ashishhiggins.shoppinwebapp.dto.OrdersDto;
import com.ashishhiggins.shoppinwebapp.entity.Orders;
import com.ashishhiggins.shoppinwebapp.entity.Transactions;
import org.hibernate.query.Order;

public class OrderMapper {

    public static OrdersDto Tranaction_OrderToOrderDto(Transactions transactions, Orders order, OrdersDto ordersDto) {
        ordersDto.setOrderId(transactions.getOrderId());
        ordersDto.setDate(order.getDate());
        ordersDto.setCoupon(order.getCoupon());
        ordersDto.setAmount(order.getAmount());
        ordersDto.setTransactionId(transactions.getTransactionId());
        ordersDto.setStatus(transactions.getStatus());

        return ordersDto;
    }
}
