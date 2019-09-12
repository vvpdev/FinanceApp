package com.hfad.financeapp.Presenter;

import com.hfad.financeapp.MainInterface;
import com.hfad.financeapp.Model.DataClass;

import java.util.ArrayList;


    // связующий класс

public class Presenter implements MainInterface.mvpPresenter {


    // переменные для конструктора презентера
    private MainInterface.mvpView view;
    private MainInterface.mvpModel model;


    // конструктор
    public Presenter (MainInterface.mvpView view){
        this.view = view;
        this.model = new DataClass();
    }


    @Override
    public void sendDataToModel(String name, int value) {
        model.addCategory(name, value);
    }

    @Override
    public void onClickRemoveCategory(int position) {
        model.removeCategory(position);
    }


    @Override
    public ArrayList<String> returnArrayStringCategory() {
        return DataClass.arrayStringCategory;
    }
}
