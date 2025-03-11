package com.Twitter.Jarvis.Service;

import com.Twitter.Jarvis.Model.OrderEntityModel;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface RazorPayService {
    OrderEntityModel createOrder(Map<String, Integer> data) throws Exception;
    String verifyPayment(Map<String, Object> data) throws Exception;
}
