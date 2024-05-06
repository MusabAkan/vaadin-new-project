package com.mskn.education.enums;

public enum EnumCategory {

    ACTION("Aksiyon"),
    ADVENTURE("Macera"),
    HORROR("Korku"),
    COMEDY("Komedi");

    private String category;

    EnumCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }
}