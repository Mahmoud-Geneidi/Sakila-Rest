package com.gov.iti.sakila.presentation.controllers;

import com.gov.iti.sakila.Services.CategoryServices;
import com.gov.iti.sakila.presentation.dto.CategoryDto;
import com.gov.iti.sakila.utils.CategoryList;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Optional;

@Path("/categories")
public class CategoryWebServices {

    private CategoryServices categoryServices = new CategoryServices();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoryById(@PathParam("id") short id) {
        Optional<CategoryDto> optionalCategoryDto = categoryServices.getCategoryById(id);
        CategoryDto categoryDto = optionalCategoryDto.orElse(null);
        if (categoryDto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(categoryDto).build();
        }
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCategory(CategoryDto category) {
        if (category == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            categoryServices.saveCategory(category);
            return Response.ok(true).build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCategory(CategoryDto category) {
        categoryServices.updateCategory(category);
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCategory(CategoryDto category) {
        categoryServices.deleteCategory(category);
        return Response.ok().build();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCategories() {
        ArrayList<CategoryDto> categories = (ArrayList<CategoryDto>) categoryServices.getAllCategories();
        CategoryList categoryList = new CategoryList(categories);
        return Response.ok(categoryList).build();
    }

    @GET
    @Path("/limit")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCategoriesByLimit(@QueryParam("start") int start, @QueryParam("limit") int limit) {
        ArrayList<CategoryDto> categories = (ArrayList<CategoryDto>) categoryServices.getAllCategoriesByLimit(start, limit);
        CategoryList categoryList = new CategoryList(categories);
        return Response.ok(categoryList).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteCategoryById(@PathParam("id") short id) {
        Optional<CategoryDto> optionalCategoryDto = categoryServices.getCategoryById(id);
        CategoryDto categoryDto = optionalCategoryDto.orElse(null);
        if (categoryDto != null) {
            categoryServices.deleteCategoryById(id);
            return Response.ok(true).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
