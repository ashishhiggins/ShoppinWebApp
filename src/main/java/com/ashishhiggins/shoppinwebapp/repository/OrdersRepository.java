package com.ashishhiggins.shoppinwebapp.repository;

import com.ashishhiggins.shoppinwebapp.dto.OrdersDto;
import com.ashishhiggins.shoppinwebapp.entity.Orders;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByUserUserId (Long orderId);

}
