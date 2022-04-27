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
        paymentModel.uid = paymentRequestEntity.uid;
        paymentModel.amount = paymentRequestEntity.amount;
        paymentModel.payment_method = paymentRequestEntity.payment_method;

        if (getPaymentSuccess()) {
            paymentModel.success = 1;
        } else {
            paymentModel.success = 0;
        }

        paymentRepository.save(paymentModel);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("payment-id", paymentModel.payment_id);
        jsonObject.put("success", paymentModel.success);

        return jsonObject.toString();
    }

    private String getRandomString() {
        String DOMAIN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 24) {
            int index = (int) (rnd.nextFloat() * DOMAIN.length());
            salt.append(DOMAIN.charAt(index));
        }
        return salt.toString();
    }

    public boolean getPaymentSuccess() {
        Random random = new Random();
        float value = random.nextFloat();
        return value > 0.1;
    }
}