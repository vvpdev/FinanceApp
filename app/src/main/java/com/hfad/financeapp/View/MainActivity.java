package com.hfad.financeapp.View;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.financeapp.R;
import com.hfad.financeapp.Repository.CategoryClass;
import com.hfad.financeapp.View.Adapters.AdapterAllCategories;
import com.hfad.financeapp.View.Adapters.RecyclerItemClickListener;

import java.util.ArrayList;


        // главная активити

public class MainActivity extends AppCompatActivity {

    Toolbar toolbarApp;
    LinearLayoutManager layoutManager;
    RecyclerView recyclerViewAllCategory;
    public static ArrayList <CategoryClass> arrayCategory = new ArrayList<>();
    public static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarApp = findViewById(R.id.toolbarApp);
        setSupportActionBar(toolbarApp);

        setTitle(R.string.main_activity);

        context = this;

        recyclerViewAllCategory = findViewById(R.id.recyclerViewAllCategories);


        // первоначальная настройка RecyclerView
        initRecyclreViewCategory();

        // задаем слушатель
        onSetListener();
    }



    void initRecyclreViewCategory(){

        // инициилизируем менеджера макета
        layoutManager = new LinearLayoutManager(context);

        // создаем объект класса адаптера
        final AdapterAllCategories adapterAllCategories = new AdapterAllCategories(context, arrayCategory);

        recyclerViewAllCategory.setLayoutManager(layoutManager);

        fillArrayCategory();

        // задаем адаптер для RecyclerView
        recyclerViewAllCategory.setAdapter(adapterAllCategories);
    }



    void onSetListener (){
        recyclerViewAllCategory.addOnItemTouchListener(

                new RecyclerItemClickListener(context, recyclerViewAllCategory, new RecyclerItemClickListener.OnItemClickListener() {

                   // обычный клик
                    @Override
                    public void onItemClick(View view, final int position) {

                        // раздуватель нового макета
                        LayoutInflater inflater = LayoutInflater.from(MainActivity.context);

                        View dialogView = inflater.inflate(R.layout.alert_dialog_layout, null);

                        // всплывающее окно
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.context);

                        // задаем вью макета к билдеру
                       builder.setView(dialogView);

                        // находим элементы для ввода данных
                        final EditText inputValue = dialogView.findViewById(R.id.inputValue);

                        builder.setTitle(R.string.new_cost)
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

                                        // тут запись данных с ввода
                                        arrayCategory.get(position).addValueToArray(Integer.parseInt(inputValue.getText().toString()));

                                        // обновляем RecyclerView
                                        recyclerViewAllCategory.getAdapter().notifyDataSetChanged();
                                    }
                                });

                AlertDialog alert = builder.create();
                alert.show();

                 }


                    // долгий клик
                    @Override
                    public void onLongItemClick(View view, int position) {



                    }
                })

        );

    }






    public void fillArrayCategory(){
        arrayCategory.add(new CategoryClass("другое"));
        arrayCategory.add(new CategoryClass("хавчик"));
        arrayCategory.add(new CategoryClass("сиги"));
        arrayCategory.add(new CategoryClass("пивчер"));
    }


}
