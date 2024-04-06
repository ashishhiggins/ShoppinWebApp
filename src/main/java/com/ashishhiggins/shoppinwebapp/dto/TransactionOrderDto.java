package com.ashishhiggins.shoppinwebapp.dto;

import jakarta.validation.Valid;
import lombok.Data;

@Data@Valid
public class TransactionOrderDto {

    private Long userId;
    private Long orderId;

    private String transactionId;

    private String status;

    private String description;

    private int StatusCode;

//    	"userId": 1,
//                "orderId": 100,
//                "transactionId": tran010100004,
//            "status": "failed",
//            "description": "Payment Failed due to invalid order id"

}
