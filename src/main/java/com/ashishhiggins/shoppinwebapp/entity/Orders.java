package com.ashishhiggins.shoppinwebapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private double amount;
    private LocalDate date;
    private String coupon;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;


}
