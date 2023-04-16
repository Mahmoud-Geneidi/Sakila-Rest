package com.gov.iti.sakila.presentation.dto;


import java.util.Date;

public class CategoryDto  {
    private Short categoryId;
    private String name;
    private Date lastUpdate;

    public CategoryDto(Short categoryId, String name, Date lastUpdate) {
        this.categoryId = categoryId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public CategoryDto() {
    }

    public Short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Short categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
