package com.gov.iti.sakila.Services;


import com.gov.iti.sakila.persistence.JPAUtil;
import com.gov.iti.sakila.persistence.dao.PaymentDao;
import com.gov.iti.sakila.persistence.entities.Payment;
import com.gov.iti.sakila.presentation.dto.PaymentDto;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class PaymentServices {


        private PaymentDao paymentDao;

        private EntityManager entityManager;

        public PaymentServices() {
            paymentDao = new PaymentDao();
            entityManager = JPAUtil.getEntityManager();
        }

        public Optional<PaymentDto> getPaymentById(int id) {
            return paymentDao.getPaymentById(id);
        }

        public List<PaymentDto> getAllPayments() {
            return paymentDao.getAllPayments();
        }

        public void savePayment(Payment payment) {
            paymentDao.save(payment);
        }

        public void updatePayment(PaymentDto paymentDto) {
            paymentDao.update(paymentDto);
        }

        public void deletePayment(PaymentDto paymentDto) {
            paymentDao.delete(paymentDto);
        }

        public List<PaymentDto> getAllPaymentsByLimit(int start, int limit) {
            return paymentDao.getAllPaymentsByLimit(start, limit);
        }

        public void deletePaymentById(int id) {
            paymentDao.deleteById(id);
        }
    }


