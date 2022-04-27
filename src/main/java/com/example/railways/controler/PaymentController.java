/**
 * Author: Chandan Kumar
 */
package com.example.railways.controler;

import com.example.railways.entities.PaymentRequestEntity;
import com.example.railways.models.PaymentModel;
import com.example.railways.repository.PaymentRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/make-payment")
    public String makePayment(@RequestBody PaymentRequestEntity paymentRequestEntity) {
        PaymentModel paymentModel = new PaymentModel();

        paymentModel.payment_id = getRandomString();
//        paymentModel.ticket_id = getRandomString();
        paymentModel.u_id = paymentRequestEntity.u_id;
        paymentModel.amount = paymentRequestEntity.amount;
        paymentModel.payment_method = paymentRequestEntity.payment_method;

        if (getPaymentSuccess()) {
            paymentModel.success = 1;
        } else {
            paymentModel.success = 0;
        }

        paymentRepository.save(paymentModel);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("payment_id", paymentModel.payment_id);
//        jsonObject.put("ticket_id", paymentModel.ticket_id);
        jsonObject.put("success", paymentModel.success);

        return jsonObject.toString();
    }

    private String getRandomString() {
        String DOMAIN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        while (stringBuilder.length() < 24) {
            int index = (int) (random.nextFloat() * DOMAIN.length());
            stringBuilder.append(DOMAIN.charAt(index));
        }
        return stringBuilder.toString();
    }

    public boolean getPaymentSuccess() {
        Random random = new Random();
        float value = random.nextFloat();
        return value > 0.1;
    }
}