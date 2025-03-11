package com.Twitter.Jarvis.ServiceImpl;

import com.Twitter.Jarvis.Model.PaymentModel;
import com.Twitter.Jarvis.Repository.PaymentRepository;
import com.Twitter.Jarvis.Service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public PaymentModel donationSave(PaymentModel paymentModel) throws Exception {
        try {
            return paymentRepository.save(paymentModel);
        } catch (Exception e) {
            return null;
        }
    }
}
