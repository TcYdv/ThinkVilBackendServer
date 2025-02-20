package com.Twitter.Jarvis.ServiceImpl;

import com.Twitter.Jarvis.Model.OrderEntityModel;
import com.Twitter.Jarvis.Repository.OrderRepository;
import com.Twitter.Jarvis.Service.RazorPayService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RazorPayServiceImpl implements RazorPayService {
    @Value("${razorpay.key}")
    private String key;

    @Value("${razorpay.secret}")
    private String secret;

    @Autowired
    private OrderRepository orderRepository;

    public OrderEntityModel createOrder(int amount) throws Exception {
        RazorpayClient client = new RazorpayClient(key, secret);

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100); // Amount in paise
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "txn_" + System.currentTimeMillis());

        Order razorpayOrder = client.orders.create(orderRequest);

        OrderEntityModel order = new OrderEntityModel();
        order.setRazorpayOrderId(razorpayOrder.get("id"));
        order.setAmount(amount);
        order.setCurrency("INR");
        order.setStatus("CREATED");
        order.setReceipt(razorpayOrder.get("receipt"));
        order.setCreatedAt(LocalDateTime.now());

        return orderRepository.save(order);
    }

    public void updateOrderStatus(String orderId, String status) {
        OrderEntityModel order = orderRepository.findByRazorpayOrderId(orderId);
        if (order != null) {
            order.setStatus(status);
            orderRepository.save(order);
        }
    }
}
