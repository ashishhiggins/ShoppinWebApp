package com.ashishhiggins.shoppinwebapp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrdersDto {

    private Long orderId;

    private double amount;

    private LocalDate date;

    private String coupon;

    private String transactionId;

    private String status;
}
