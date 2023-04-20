package com.gov.iti.sakila.presentation.controllers;

import com.gov.iti.sakila.Services.PaymentServices;
import com.gov.iti.sakila.persistence.entities.Payment;
import com.gov.iti.sakila.presentation.dto.PaymentDto;
import com.gov.iti.sakila.utils.PaymentList;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Optional;

@Path("/payments")
public class PaymentWebServices {

    private PaymentServices paymentServices = new PaymentServices();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaymentById(@PathParam("id") int id) {
        Optional<PaymentDto> optionalPaymentDto = paymentServices.getPaymentById(id);
        PaymentDto paymentDto = optionalPaymentDto.orElse(null);
        if (paymentDto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(paymentDto).build();
        }
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePayment(Payment payment) {
        if (payment == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            paymentServices.savePayment(payment);
            return Response.ok(true).build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePayment(PaymentDto payment) {
        paymentServices.updatePayment(payment);
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePayment(PaymentDto payment) {
        paymentServices.deletePayment(payment);
        return Response.ok().build();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPayments() {
        ArrayList<PaymentDto> payments = (ArrayList<PaymentDto>) paymentServices.getAllPayments();
        PaymentList paymentList = new PaymentList(payments);
        return Response.ok(paymentList).build();
    }

    @GET
    @Path("/limit")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPaymentsByLimit(@QueryParam("start") int start, @QueryParam("limit") int limit) {
        ArrayList<PaymentDto> payments = (ArrayList<PaymentDto>) paymentServices.getAllPaymentsByLimit(start, limit);
        PaymentList paymentList = new PaymentList(payments);
        return Response.ok(paymentList).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deletePaymentById(@PathParam("id") int id) {
        Optional<PaymentDto> optionalPaymentDto = paymentServices.getPaymentById(id);
        PaymentDto paymentDto = optionalPaymentDto.orElse(null);
        if (paymentDto != null) {
            paymentServices.deletePayment(paymentDto);
            return Response.ok(true).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
