package com.hfad.financeapp;


    // интерфейс для управляющих методов элементов паттерна MVP

import java.util.ArrayList;

public interface MainInterface {


    // для активити - сообщает о действиях пользователя
    interface mvpView{

        void onShowListCategory();
    }

    // модель - работа непосредственно с данными: запись и удаление
    interface mvpModel{
        void addCategory(String nameCategory, int value);         // добавляем в массив
        void removeCategory(int position);      // стираем из массива

    }

    // связующее звено в паттерне MVP - координация действий между Model и View
    interface  mvpPresenter{

        void sendDataToModel(String name, int value);         // отправить данные для записи в массивы
        void onClickRemoveCategory(int position);              // нажатие на айтем списка
        ArrayList<String> returnArrayStringCategory();          // для возврата массива к ListView

    }





}
