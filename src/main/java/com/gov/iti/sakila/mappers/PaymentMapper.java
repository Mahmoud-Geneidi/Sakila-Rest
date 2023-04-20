package com.gov.iti.sakila.mappers;
import com.gov.iti.sakila.persistence.entities.Payment;
import com.gov.iti.sakila.presentation.dto.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PaymentMapper {

    @Mapping(source = "paymentId",target = "paymentId")
    @Mapping(source = "amount",target = "amount")
    @Mapping(source = "paymentDate",target = "paymentDate")
    @Mapping(source = "lastUpdate",target = "lastUpdate")
    PaymentDto paymentToPaymentDto(Payment payment);

    @Mapping(source = "paymentId",target = "paymentId")
    @Mapping(source = "amount",target = "amount")
    @Mapping(source = "paymentDate",target = "paymentDate")
    @Mapping(source = "lastUpdate",target = "lastUpdate")
    Payment paymentDtoToPayment(PaymentDto paymentDto);
}
