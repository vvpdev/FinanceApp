package com.hfad.financeapp.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.hfad.financeapp.MainInterface;
import com.hfad.financeapp.Presenter.Presenter;
import com.hfad.financeapp.R;

public class MainActivity extends AppCompatActivity implements MainInterface.mvpView {

    final Context context = this;   // контекст этой активити

    // адаптер
    ArrayAdapter <String> adapter;

    //ListView
    ListView listAllCategory;

    private MainInterface.mvpPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);

        setTitle("Расходы");

        // ListView для отображения всех добавленных категорий
        listAllCategory = findViewById(R.id.listAllCategory);



        // кнопка "к диаграмме"
        findViewById(R.id.moveToChart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToChart = new Intent (MainActivity.this, PieChartActivity.class);
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

                                        // передаем данные презентеру
                                        presenter.sendDataToModel(
                                                inputNameCategory.getText().toString(),
                                                Integer.parseInt(inputValueCategory.getText().toString()));

                                        // обновить listView
                                        adapter.notifyDataSetChanged();
                                    }
                                });

                AlertDialog alert = builder.create();
                alert.show();
            }

        });


        // слушатель нажатия на item
        listAllCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                // всплывающее окно
                AlertDialog.Builder builderDelete = new AlertDialog.Builder(context);

                builderDelete.setTitle("Удалить категорию?");  // заголовок
                builderDelete.setPositiveButton("да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {

                        presenter.onClickRemoveCategory(position);

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

        // показ ListView
        onShowListCategory();
}



    @Override
    public void onShowListCategory() {

        adapter = new ArrayAdapter<>(

                this,

                android.R.layout.simple_list_item_1,

                presenter.returnArrayStringCategory()
        );

        listAllCategory.setAdapter(adapter);

    }
}
