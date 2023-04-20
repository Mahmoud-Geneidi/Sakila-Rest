package com.gov.iti.sakila.utils;


import com.gov.iti.sakila.presentation.dto.PaymentDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement
public class PaymentList {

    private ArrayList<PaymentDto> payments;

    public PaymentList(ArrayList<PaymentDto> payments) {
        this.payments = payments;
    }

    public PaymentList() {
    }

    @XmlElement(name = "payment")
    public ArrayList<PaymentDto> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<PaymentDto> payments) {
        this.payments = payments;
    }
}
