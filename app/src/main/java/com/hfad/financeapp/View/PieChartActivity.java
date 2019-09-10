package com.hfad.financeapp.View;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hfad.financeapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class PieChartActivity extends AppCompatActivity {

    // для цветов
    int r;
    int g;
    int b;


    PieChartView pieChartView;

    List<SliceValue> pieData = new ArrayList<>();   // массив с данными

    TextView textCategoriesNull;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        setTitle("диаграмма расходов");

        // стрелка назад в тулбаре
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        textCategoriesNull = findViewById(R.id.textCategoriesNull);



        // рандомизатор для цветов
        Random rand = new Random();


        // находим на макета
        pieChartView = findViewById(R.id.chart);


        // если массив не пустой
        if (!MainActivity.arrayCategories.isEmpty()){


            // скроем предупреждение
            textCategoriesNull.setVisibility(View.GONE);


            // проходим по массиву категорий
            for (int i = 0; i < MainActivity.arrayCategories.size(); i++){

                //для создания рандомного цвета
                r = rand.nextInt(255);
                g = rand.nextInt(255);
                b = rand.nextInt(255);


                // рандомный цвет
                int randomColor = Color.rgb(r, g, b);


                pieData.add(new SliceValue(

                        MainActivity.arrayCategories.get(i).getValue(), randomColor)
                        .setLabel(MainActivity.arrayCategories.get(i).getNameCategory() + " " + MainActivity.arrayCategories.get(i).getValue()));
            }


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



        // если массив пустой - не добавлено ни одной категории
        else {

            pieChartView.setVisibility(View.GONE);

        }






    }
}