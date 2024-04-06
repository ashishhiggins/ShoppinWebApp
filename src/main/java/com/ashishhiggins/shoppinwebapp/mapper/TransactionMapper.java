package com.ashishhiggins.shoppinwebapp.mapper;

import com.ashishhiggins.shoppinwebapp.dto.TransactionOrderDto;
import com.ashishhiggins.shoppinwebapp.entity.Transactions;

public class TransactionMapper {

    public static Transactions mapToTransactions(TransactionOrderDto transactionOrderDto, Transactions transactions) {
        transactions.setStatus(transactionOrderDto.getStatus());
        transactions.setDescription(transactionOrderDto.getDescription());
        transactions.setTransactionId(transactionOrderDto.getTransactionId());
        transactions.setOrderId(transactionOrderDto.getOrderId());
        return transactions;
    }
}
