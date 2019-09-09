package com.hfad.financeapp;


    // база данных для категорий

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;


public class DateBase extends SQLiteOpenHelper {


    private static final String DB_NAME = "FinanceDateBase";

    private static final int DB_VERSION = 1;

    public DateBase(@Nullable Context context, @Nullable String DB_NAME, @Nullable SQLiteDatabase.CursorFactory factory, int DB_VERSION) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        // создаем таблицу
        db.execSQL("CREATE TABLE Category (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name_Category TEXT," +                     // название категории
                "VALUE INTEGER)" );                         // значение
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
