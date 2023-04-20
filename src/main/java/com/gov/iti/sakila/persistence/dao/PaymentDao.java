package com.gov.iti.sakila.persistence.dao;

import com.gov.iti.sakila.mappers.PaymentMapper;
import com.gov.iti.sakila.persistence.Database;
import com.gov.iti.sakila.persistence.entities.Payment;
import com.gov.iti.sakila.presentation.dto.PaymentDto;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PaymentDao extends GenericDao {


    private PaymentMapper paymentMapper = Mappers.getMapper(PaymentMapper.class);

    public PaymentDao() {
        super(Payment.class);
    }

    public Optional<PaymentDto> getPaymentById(int id ) {
        Optional<Payment> paymentOptional = super.getById(id);
        return paymentOptional.map(paymentMapper::paymentToPaymentDto);
    }

    public List<PaymentDto> getAllPayments() {
        List<Payment> payments = getAll();
        return payments.stream().map(paymentMapper::paymentToPaymentDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void save(Payment payment) {
        super.save(payment);
    }

    public void update(Object entity) {
        super.update(entity);
    }

    public void delete(Object entity) {
        super.delete(entity);
    }

    public List<PaymentDto> getAllPaymentsByLimit(int start, int limit) {
        List<Payment> payments = getAll();
        int endIndex = Math.min(start + limit, payments.size());
        return payments.subList(start, endIndex).stream()
                .map(paymentMapper::paymentToPaymentDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void deleteById(int id) {
        Optional<Payment> paymentOptional = getById(id);
        paymentOptional.ifPresent(payment -> Database.doInTransactionWithoutResult(entityManager -> {
            entityManager.remove(entityManager.contains(payment) ? payment : entityManager.merge(payment));
        }));
    }
}


