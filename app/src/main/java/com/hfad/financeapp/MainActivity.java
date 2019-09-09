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
        pieData.add(new SliceValue(15, Color.BLUE));
        pieData.add(new SliceValue(25, Color.GRAY));
        pieData.add(new SliceValue(10, Color.RED));
        pieData.add(new SliceValue(60, Color.MAGENTA));

        // добавляем данные
        PieChartData pieChartData = new PieChartData(pieData);

        pieChartView.setPieChartData(pieChartData);


    }
}
