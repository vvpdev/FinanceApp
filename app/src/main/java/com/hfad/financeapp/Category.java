package com.hfad.financeapp;


    // простой класс для объектов - категорий

public class Category {


        private String nameCategory;
        private int value;

        // конструктор объектов
        Category (String nameCategory, int value){
            this.nameCategory = nameCategory;
            this.value = value;
        }


    String getNameCategory() {
        return nameCategory;
    }

    int getValue() {
        return value;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
