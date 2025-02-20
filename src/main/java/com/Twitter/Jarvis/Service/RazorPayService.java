package com.Twitter.Jarvis.Service;

import com.Twitter.Jarvis.Model.OrderEntityModel;
import org.springframework.stereotype.Service;

@Service
public interface RazorPayService {
    OrderEntityModel createOrder(int amount) throws Exception;
}
