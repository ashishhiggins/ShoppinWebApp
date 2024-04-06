package com.ashishhiggins.shoppinwebapp.Controller;

import com.ashishhiggins.shoppinwebapp.dto.TransactionOrderDto;
import com.ashishhiggins.shoppinwebapp.service.IOrdersService;
import com.ashishhiggins.shoppinwebapp.service.ITransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/apis/coupons", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class TransactionController {

    private ITransactionService iTransactionService;
    private IOrdersService iOrdersService;
    @GetMapping("/pay/{orderId}")
    public ResponseEntity<TransactionOrderDto> makePayments(@RequestParam Long orderId) {


        TransactionOrderDto dto = iTransactionService.makePayment(orderId);
        return new ResponseEntity<>(dto, HttpStatusCode.valueOf(dto.getStatusCode()));
    }


}
