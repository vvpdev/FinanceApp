package com.hfad.financeapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final Context context = this;   // контекст этой активити

    // массив для категорий
  public static ArrayList <Category> arrayCategories = new ArrayList<>();

    // строковый массив для отображения в ListView
    ArrayList <String> arrayCategoriesString = new ArrayList<>();

    // адаптер
    ArrayAdapter <String> adapter;

    //ListView
    ListView listAllCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Расходы");

        // ListView для отображения всех добавленных категорий
        listAllCategory = findViewById(R.id.listAllCategory);


        // кнопка "к диаграмме"
        findViewById(R.id.moveToChart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToChart = new Intent (MainActivity.this, PieChart.class);
                startActivity(moveToChart);
            }
        });


        // кнопка "создать категорию"
        findViewById(R.id.createCategory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // раздуватель нового макета
                LayoutInflater inflater = LayoutInflater.from(context);

                // новый View
                @SuppressLint("InflateParams") View dialogView = inflater.inflate(R.layout.alert_dialog_layout, null);

                // всплывающее окно
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                // задаем вью макета к билдеру
                builder.setView(dialogView);

                // находим элементы для ввода данных
                final EditText inputNameCategory = dialogView.findViewById(R.id.input_NameCategory);
                final EditText inputValueCategory = dialogView.findViewById(R.id.input_ValueCategory);

                builder.setTitle("Новая категория")
                        .setCancelable(false)       // ?????

                        .setNegativeButton("отмена",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                       dialog.cancel();
                                    }
                                })

                        .setPositiveButton("создать",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                        // добавляем новую категорию
                                        arrayCategories.add(new Category(inputNameCategory.getText().toString(), Integer.parseInt(inputValueCategory.getText().toString())));
                                        arrayCategoriesString.add(inputNameCategory.getText().toString());

                                    }
                                });

                AlertDialog alert = builder.create();
                alert.show();
            }

        });


        // адаптер
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arrayCategoriesString
        );

        listAllCategory.setAdapter(adapter);



        // слушатель долгого нажатия на item
        listAllCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                // всплывающее окно
                AlertDialog.Builder builderDelete = new AlertDialog.Builder(context);

                builderDelete.setTitle("Удалить категорию?");  // заголовок
                builderDelete.setPositiveButton("да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {

                        // удаление айтема
                        arrayCategoriesString.remove(position);
                        arrayCategories.remove(position);

                        // обновить listView
                        adapter.notifyDataSetChanged();
                    }
                });
                builderDelete.setNegativeButton("нет", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {

                        dialog.cancel();
                    }
                });

                // показать сообщение
                AlertDialog alert = builderDelete.create();
                alert.show();

            }
        });


}

}
