package com.apps.kondratenko.platizhka;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 6; //нанокостыль

    private static final String DATABASE_NAME = "crud.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Тут створюється таблиця
        String CREATE_TABLE_PAYMENT = "CREATE TABLE " +Payment.TABLE  + "("
                + Payment.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Payment.KEY_name + " TEXT, "
                + Payment.KEY_stdId + " TEXT, "
                + Payment.KEY_groupId + " TEXT )";

        db.execSQL(CREATE_TABLE_PAYMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Видаляємо застарілу таблицю в БД
        db.execSQL("DROP TABLE IF EXISTS " + Payment.TABLE);
        // І створюємо нову
        onCreate(db);

    }
}