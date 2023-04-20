package com.gov.iti.sakila.mappers;

import com.gov.iti.sakila.persistence.entities.Payment;
import com.gov.iti.sakila.presentation.dto.PaymentDto;

public class PaymentMapperImpl implements PaymentMapper{
    @Override
    public PaymentDto paymentToPaymentDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setPaymentId( payment.getPaymentId() );
        paymentDto.setAmount( payment.getAmount() );
        paymentDto.setPaymentDate( payment.getPaymentDate() );
        paymentDto.setLastUpdate( payment.getLastUpdate() );

        return paymentDto;
    }

    @Override
    public Payment paymentDtoToPayment(PaymentDto paymentDto) {
        if ( paymentDto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setPaymentId( paymentDto.getPaymentId() );
        payment.setAmount( paymentDto.getAmount() );
        payment.setPaymentDate( paymentDto.getPaymentDate() );
        payment.setLastUpdate( paymentDto.getLastUpdate() );

        return payment;
    }
}
