package com.hfad.financeapp;


    // интерфейс для управляющих методов элементов паттерна MVP

public interface MainInterface {


    // для активити - сообщает о действиях пользователя
    interface mvpView{

        void onShowListCategory();
    }

    // модель - работа непосредственно с данными: запись и удаление
    interface mvpModel{
        void addCategory(String nameCategory, int value);         // добавляем в массив
        void removeCategory();      // стираем из массива

    }

    // связующее звено в паттерне MVP - координация действий между Model и View
    interface  mvpPresenter{

        void onClickCreatCategory();    // нажатие кнопки Создать категорию
        void onClickRemoveCategory();   // нажатие на айтем списка
        void onClickGotoChart();        // кнопка перехода к диаграмме

    }





}
