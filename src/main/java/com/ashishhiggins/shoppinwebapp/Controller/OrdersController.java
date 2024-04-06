package com.ashishhiggins.shoppinwebapp.Controller;

import com.ashishhiggins.shoppinwebapp.dto.OrdersDto;
import com.ashishhiggins.shoppinwebapp.entity.Orders;
import com.ashishhiggins.shoppinwebapp.service.IOrdersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/apis/orders", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class OrdersController {

    private IOrdersService iOrdersService;

    @GetMapping("/fetchOrders/{orderId}")
    public ResponseEntity<Orders> fetchOrdersById(@PathVariable Long orderId) {
        Orders orders = iOrdersService.fetchOrderById(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @PostMapping("/createOrder/{userId}/{productId}/{quantity}/{coupon}")
    public ResponseEntity<Orders> createOrder(@PathVariable Long userId, @PathVariable Long productId, @PathVariable int quantity, @PathVariable String coupon) {
        Orders orders = iOrdersService.createOrder(userId, productId, quantity, coupon);
        return ResponseEntity.status(HttpStatus.CREATED).body(orders);
    }

    @GetMapping("/fetchAllOrders/{userId}")
    public ResponseEntity<List<Orders>> fetchAllOrdersByUserId(@PathVariable Long userId) {
        List<Orders> orders = iOrdersService.fetchAllOrdersByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }
    @GetMapping("{userId}/orders/{ordersId}")
public ResponseEntity<OrdersDto> fetchOrdersByUserIdAndOrderId(@PathVariable Long userId, @PathVariable Long ordersId) {
        return ResponseEntity.status(HttpStatus.OK).body(iOrdersService.findByUserUserIdAndOrderId(userId, ordersId).orElse(null));
    }

}
