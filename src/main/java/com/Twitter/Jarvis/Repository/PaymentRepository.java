package com.Twitter.Jarvis.Repository;

import com.Twitter.Jarvis.Model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
}
