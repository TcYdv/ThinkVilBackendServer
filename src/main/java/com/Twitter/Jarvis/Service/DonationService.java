package com.Twitter.Jarvis.Service;

import com.Twitter.Jarvis.Model.PaymentModel;

public interface DonationService {
    PaymentModel donationSave(PaymentModel paymentModel) throws Exception;
}
