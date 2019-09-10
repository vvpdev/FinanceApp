package com.hfad.financeapp.Model;


    // интерфейс для управляющих методов элементов паттерна MVP

public interface MainInterface {


    // для активити
    interface mvpView{

        // метод для создания категории в массиве
        Category onCreateCategory (String nameCategory, int value);

        // удаление категории из массива
        void onDeleteCategory (int i);

    }

    // модель - работа непосредственно с данными: запись и удаление
    interface mvpModel{

    }


    // связующее звено в паттерне MVP - координация действий между Model и View
    interface  mvpPresenter{

    }





}
