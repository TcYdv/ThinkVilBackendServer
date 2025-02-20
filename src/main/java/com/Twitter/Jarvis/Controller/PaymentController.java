package com.Twitter.Jarvis.Controller;

import com.Twitter.Jarvis.Model.OrderEntityModel;
import com.Twitter.Jarvis.Service.RazorPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private RazorPayService razorpayService;

    @PostMapping("/create-order")
    public OrderEntityModel createOrder(@RequestParam int amount) {
        try {
            return razorpayService.createOrder(amount);
        } catch (Exception e) {
            throw new RuntimeException("Order creation failed: " + e.getMessage());
        }
    }

    @PostMapping("/verify-payment")
    public String verifyPayment(@RequestParam String razorpayOrderId,
                                @RequestParam String razorpayPaymentId,
                                @RequestParam String razorpaySignature) {
        // Verification logic to be implemented here
        return "Payment verification feature under construction.";
    }
}
