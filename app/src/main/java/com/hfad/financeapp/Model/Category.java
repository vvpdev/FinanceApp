package com.hfad.financeapp.Model;


    // простой класс для объектов - категорий

public class Category {


        private String nameCategory;
        private int value;

        // конструктор объектов
        public Category(String nameCategory, int value){
            this.nameCategory = nameCategory;
            this.value = value;
        }


    public String getNameCategory() {
        return nameCategory;
    }

    public int getValue() {
        return value;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
