package com.ashishhiggins.shoppinwebapp.service.Impl;

import com.ashishhiggins.shoppinwebapp.dto.TransactionOrderDto;
import com.ashishhiggins.shoppinwebapp.entity.Orders;
import com.ashishhiggins.shoppinwebapp.entity.Transactions;
import com.ashishhiggins.shoppinwebapp.exception.NoOrderFoundException;
import com.ashishhiggins.shoppinwebapp.mapper.TransactionMapper;
import com.ashishhiggins.shoppinwebapp.repository.OrdersRepository;
import com.ashishhiggins.shoppinwebapp.repository.TransactionRepository;
import com.ashishhiggins.shoppinwebapp.service.ITransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service@AllArgsConstructor
public class TransactionServiceImpl implements ITransactionService {

    private OrdersRepository ordersRepository;
    private TransactionRepository transactionRepository;
    @Override
    public TransactionOrderDto makePayment(Long orderId) {

        Orders order = ordersRepository.findById(orderId).orElseThrow(
                () -> new NoOrderFoundException("No order found with id: " + orderId));

        TransactionOrderDto transactionOrderDto = getTransactionDetails();
        transactionOrderDto.setOrderId(orderId);
        transactionOrderDto.setUserId(order.getOrderId());
        transactionOrderDto.setTransactionId("tran" + order.getOrderId() + new Random().nextInt(1000));
        transactionRepository.save(TransactionMapper.mapToTransactions(transactionOrderDto, new Transactions()));


        return transactionOrderDto;
    }

    public TransactionOrderDto getTransactionDetails() {
        // Create a new TransactionOrderDto object
      TransactionOrderDto transactionOrderDto = new TransactionOrderDto();
        int statusCode = new Random().nextInt(6) + 1;

        // Generate a random status code between 1 and 6
        switch (statusCode) {
            case 1:
                transactionOrderDto.setStatusCode(200);
                transactionOrderDto.setStatus("successful");
                transactionOrderDto.setDescription(null); // No description needed for successful transactions
                break;
            case 2:
                transactionOrderDto.setStatusCode(400);
                transactionOrderDto.setStatus("failed");
                transactionOrderDto.setDescription("Payment Failed as amount is invalid");
                break;
            case 3:
                transactionOrderDto.setStatusCode(400);
                transactionOrderDto.setStatus("failed");
                transactionOrderDto.setDescription("Payment Failed from bank");
                break;
            case 4:
                transactionOrderDto.setStatusCode(400);
                transactionOrderDto.setStatus("failed");
                transactionOrderDto.setDescription("Payment Failed due to invalid order id");
                break;
            case 5:
                transactionOrderDto.setStatusCode(504);
                transactionOrderDto.setStatus("failed");
                transactionOrderDto.setDescription("No response from payment server");
                break;
            case 6:
                transactionOrderDto.setStatusCode(405);
                transactionOrderDto.setStatus("failed");
                transactionOrderDto.setDescription("Order is already paid for");
                break;
            default:
                // Handle other status codes if needed
                break;
        }

        return transactionOrderDto;
    }
}
