package com.hfad.financeapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class MainActivity extends AppCompatActivity {



    PieChartView pieChartView;

    List<SliceValue> pieData = new ArrayList<>();   // массив с данными

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Диаграмма");


        // находим на макета
        pieChartView = (PieChartView) findViewById(R.id.chart);

        // создаем данные
        pieData.add(new SliceValue(15, Color.BLUE).setLabel("4551"));
        pieData.add(new SliceValue(25, Color.GRAY).setLabel("4556"));
        pieData.add(new SliceValue(10, Color.RED).setLabel("455"));
        pieData.add(new SliceValue(60, Color.MAGENTA).setLabel("54561"));

        // добавляем данные
        PieChartData pieChartData = new PieChartData(pieData);

        // показ подписей и размер текста
        pieChartData.setHasLabels(true).setValueLabelTextSize(20);

        // надпись в центре
        pieChartData
                .setHasCenterCircle(true)                                         // включаем текст в центре
                .setCenterText1("Sales in million")                              // задаем текст
                .setCenterText1FontSize(20)                                      // размер
                .setCenterText1Color(Color.parseColor("#0097A7"));     // цвет


        // приаязываем данные к диагрмме на макете
        pieChartView.setPieChartData(pieChartData);


    }
}
