package com.hfad.financeapp.Model;

import android.graphics.Color;

import com.hfad.financeapp.MainInterface;

import java.util.ArrayList;
import java.util.Random;

import lecho.lib.hellocharts.model.SliceValue;


        // класс для данных (массивов)

public class DataClass implements MainInterface.mvpModel {

    // массив для созданных категорий
    public static ArrayList <Category> arrayCategories = new ArrayList<>();

    // массив с данными для диаграммы
    public static ArrayList <SliceValue> arrayPieData = new ArrayList<>();

    // массив с данными для диаграммы для ListView
    public static ArrayList <String> arrayStringCategory = new ArrayList<>();

    // рандомизатор для цветов
    Random rand = new Random();


    // метод генерации цветов
    private int generateColor(){

        // для цветов
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);

        // рандомный цвет
        int randomColor = Color.rgb(r, g, b);

        return randomColor;
    }


    // метод для добавления категорий в массивы
    @Override
    public void addCategory(String nameCategory, int value) {

        arrayCategories.add(new Category(nameCategory, value));

        arrayPieData.add(new SliceValue(value, generateColor()).setLabel(nameCategory + " " + value));

        arrayStringCategory.add(nameCategory);
    }

    // метод для удалений категорий
    @Override
    public void removeCategory(int position) {

        arrayCategories.remove(position);
        arrayPieData.remove(position);
        arrayStringCategory.remove(position);
    }

}

