package com.hfad.financeapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class PieChart extends AppCompatActivity {


    PieChartView pieChartView;

    List<SliceValue> pieData = new ArrayList<>();   // массив с данными


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        setTitle("диаграмма");

        // стрелка назад в тулбаре
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        // находим на макета
        pieChartView = (PieChartView) findViewById(R.id.chart);

        // создаем данные
        pieData.add(new SliceValue(900, Color.BLUE).setLabel("900"));
        pieData.add(new SliceValue(456, Color.GRAY).setLabel("456"));
        pieData.add(new SliceValue(785, Color.RED).setLabel("785"));
        pieData.add(new SliceValue(157, Color.MAGENTA).setLabel("157"));

        // добавляем данные
        PieChartData pieChartData = new PieChartData(pieData);

        // показ подписей и размер текста
        pieChartData.setHasLabels(true).setValueLabelTextSize(20);

        // надпись в центре
        pieChartData
                .setHasCenterCircle(true)                                         // включаем текст в центре
                .setCenterText1("расходы")                              // задаем текст
                .setCenterText1FontSize(20)                                      // размер
                .setCenterText1Color(Color.parseColor("#0097A7"));     // цвет


        // приаязываем данные к диагрмме на макете
        pieChartView.setPieChartData(pieChartData);





    }
}
