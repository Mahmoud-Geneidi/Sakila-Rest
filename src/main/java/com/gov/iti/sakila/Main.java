package com.gov.iti.sakila;

import com.gov.iti.sakila.Services.CategoryServices;

public class Main {
    public static void main(String[] args) {

        CategoryServices categoryServices = new CategoryServices();
        System.out.println(categoryServices.getAllCategories());
    }
}
