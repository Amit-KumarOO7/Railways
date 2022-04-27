package com.example.railways.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class PaymentModel {

    public String payment_id;

    public int amount;

    public String uid;

    public int success;

    public String payment_method;
}
