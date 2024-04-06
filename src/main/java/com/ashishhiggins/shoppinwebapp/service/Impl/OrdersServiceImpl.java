package com.ashishhiggins.shoppinwebapp.service.Impl;

import com.ashishhiggins.shoppinwebapp.dto.OrdersDto;
import com.ashishhiggins.shoppinwebapp.entity.*;
import com.ashishhiggins.shoppinwebapp.exception.NoCouponFoundException;
import com.ashishhiggins.shoppinwebapp.exception.NoOrderFoundException;
import com.ashishhiggins.shoppinwebapp.exception.NoProductFoundException;
import com.ashishhiggins.shoppinwebapp.mapper.OrderMapper;
import com.ashishhiggins.shoppinwebapp.repository.*;
import com.ashishhiggins.shoppinwebapp.service.IOrdersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service@AllArgsConstructor
public class OrdersServiceImpl implements IOrdersService{

    private OrdersRepository ordersRepository;
    private ProductRepository productRepository;
    private CouponRepository couponRepository;
    private UserRepository userRepository;
    private TransactionRepository transactionRepository;

    @Override
    public Orders fetchOrderById(Long orderId) {
        Optional<Orders> orders = ordersRepository.findById(orderId);
        if(orders.isPresent()){
            return orders.get();
        }
        throw new NoOrderFoundException("No order found with id: "+orderId);
    }

    @Override
    public Orders createOrder(Long userId, Long productId, int quantity, String coupon) {

        Optional<Users> users = userRepository.findById(userId);
        if(users.isEmpty()){
           users  = Optional.of(new Users(userId));
              userRepository.save(users.get());
        }


            Product product = productRepository.findById(productId).orElseThrow(()->new NoProductFoundException("No product found with id: "+productId));

            if(quantity > product.getAvailable()){
                throw new NoOrderFoundException("Quantity of product is less than required");
            }

            Coupon cp = couponRepository.findByCode(coupon).orElseThrow(()->new NoCouponFoundException("No coupon found with code: "+coupon));
            double disc = cp.getDiscount();
            double amountd = product.getPrice() * quantity;
            amountd = amountd - (amountd * disc / 100);

            Orders order = new Orders();
            order.setAmount(amountd);
            order.setCoupon(coupon);
            order.setDate(java.time.LocalDate.now());
            order.setUser(users.get());

            ordersRepository.save(order);

            product.setAvailable(product.getAvailable() - quantity);
            productRepository.save(product);

            return order;
    }

    @Override
    public List<Orders> fetchAllOrdersByUserId(Long userId) {
        Optional<List<Orders>> orders = Optional.ofNullable(ordersRepository.findByUserUserId(userId));
        if(orders.isPresent()){
            return orders.get();
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<OrdersDto> findByUserUserIdAndOrderId(Long userId, Long orderId) {

        Optional<Orders> orders = ordersRepository.findByUserUserId(userId).stream().filter(order -> order.getOrderId().equals(orderId)).findFirst();

        if(!orders.isPresent()){
            throw new NoOrderFoundException("No order found with id: "+orderId);
        }
        Optional<Transactions> transactions = Optional.ofNullable(transactionRepository.findByOrderId(orders.get().getOrderId()));
        if (transactions.isEmpty()) {
            throw new NoOrderFoundException("No transaction found for order id: " + orderId);
        }

        return Optional.of(OrderMapper.Tranaction_OrderToOrderDto(transactions.get(), orders.get(), new OrdersDto()));
    }
}
