package com.corneliacalin.sda.onlineanimalshop.service.dto;

import com.corneliacalin.sda.onlineanimalshop.model.Category;

import javax.persistence.*;

public class CategoryDTO {

    private Long id;
    private String name;
    private Long parentCategoryId;


    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
