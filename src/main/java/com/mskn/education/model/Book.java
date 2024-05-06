package com.mskn.education.model;
import com.mskn.education.enums.EnumCategory;

public class Book {

    private Long id;
    private String name;
    private EnumCategory category;

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

    public EnumCategory getCategory() {
        return category;
    }

    public void setCategory(EnumCategory category) {
        this.category = category;
    }
}
