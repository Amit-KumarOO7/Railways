/**
 * Author: Chandan Kumar
 */
package com.example.railways.repository;

import com.example.railways.models.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {

    @Query(value = "SELECT record FROM payments WHERE record.payment_id=:paymentID AND record.u_id=:uid", nativeQuery = true)
    List<PaymentModel> getPaymentList(String paymentID, String uid);
}
