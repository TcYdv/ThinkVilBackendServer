package com.Twitter.Jarvis.Repository;

import com.Twitter.Jarvis.Model.OrderEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntityModel, Long> {
    OrderEntityModel findByRazorpayOrderId(String orderId);
}