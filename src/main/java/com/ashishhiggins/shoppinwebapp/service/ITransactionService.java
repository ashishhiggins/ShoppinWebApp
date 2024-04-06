package com.ashishhiggins.shoppinwebapp.service;

import com.ashishhiggins.shoppinwebapp.dto.TransactionOrderDto;

public interface ITransactionService {

    TransactionOrderDto makePayment(Long orderId);
}
