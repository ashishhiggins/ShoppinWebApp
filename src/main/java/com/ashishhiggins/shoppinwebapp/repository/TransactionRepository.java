package com.ashishhiggins.shoppinwebapp.repository;

import com.ashishhiggins.shoppinwebapp.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, String> {

    Transactions findByOrderId(Long orderId);
}
