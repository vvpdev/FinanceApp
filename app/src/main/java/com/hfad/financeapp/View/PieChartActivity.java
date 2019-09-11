package com.hfad.financeapp.View;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hfad.financeapp.Model.DataClass;
import com.hfad.financeapp.R;

import java.util.Objects;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.view.PieChartView;

public class PieChartActivity extends AppCompatActivity {


    // диаграмма
    PieChartView pieChartView;

    // текст, если ВООБЩЕ не создано категорий
    TextView textCategoriesNull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        setTitle("диаграмма расходов");

        // стрелка назад в тулбаре
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        textCategoriesNull = findViewById(R.id.textCategoriesNull);

        pieChartView = findViewById(R.id.chart);

        // если массив для диаграммы не пустой
        if (!DataClass.arrayPieData.isEmpty()){

            // скроем предупреждение
            textCategoriesNull.setVisibility(View.GONE);

            // добавляем данные
            PieChartData pieChartData = new PieChartData(DataClass.arrayPieData);

            // показ подписей и размер текста
            pieChartData.setHasLabels(true).setValueLabelTextSize(20);

            // надпись в центре
            pieChartData
                    .setHasCenterCircle(true)                                         // включаем текст в центре
                    .setCenterText1("расходы")                                       // задаем текст
                    .setCenterText1FontSize(20)                                      // размер
                    .setCenterText1Color(Color.parseColor("#0097A7"));     // цвет

            // приаязываем данные к диагрмме на макете
            pieChartView.setPieChartData(pieChartData);
        }


        // если массив пустой - т.е. не добавлено ни одной категории
        else {
            pieChartView.setVisibility(View.GONE);
        }






    }
}