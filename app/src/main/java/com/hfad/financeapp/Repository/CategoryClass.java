package com.hfad.financeapp.Repository;

import java.util.ArrayList;

    //класс для объектов - Категории
public class CategoryClass {

    String name;
    ArrayList<Integer> arrayValues;


    // каждая категория имееет свое имя и привязанный к ней массив значений
    // можно добавлять и удалять отдельные значения(расходы) у каждой категории
    // в RecyclerView показывается суммарное значение по каждой категории - метод getSummValue()


    public CategoryClass(String name){
        this.name = name;
        this.arrayValues = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<Integer> getArrayValues(){
        return arrayValues;
    }

    public int getPositionValue(int position){
        return arrayValues.get(position);
    }

    public void addValueToArray(int value){
        arrayValues.add(value);
    }

    public void removeValue(int position){
        arrayValues.remove(position);
    }


    public int getSummValue(){

        int summ = 0;

        for (int i = 0; i < arrayValues.size(); i++){
            summ = summ + arrayValues.get(i);
        }

        return summ;
    }



}



