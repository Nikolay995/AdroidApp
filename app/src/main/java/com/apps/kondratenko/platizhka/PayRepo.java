package com.apps.kondratenko.platizhka;

/**
 * Created by strik on 18.12.2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import java.util.ArrayList;
        import java.util.HashMap;

public class PayRepo {
    private DBHelper dbHelper;

    public PayRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Payment payment) {
        //Ініціюємо звязок для запису даних
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Payment.KEY_stdId, payment.stdId);
        values.put(Payment.KEY_groupId,payment.groupId);
        values.put(Payment.KEY_name, payment.name);
        // Додаємо рядок
        long payment_Id = db.insert(Payment.TABLE, null, values);
        db.close(); //Закриваємо звязок з БД
        return (int) payment_Id;
    }

    public void delete(int payment_Id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Payment.TABLE, Payment.KEY_ID + "= ?", new String[]{String.valueOf(payment_Id)});
        db.close(); // Закриваємо звязок з БД
    }

    public void update(Payment payment) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Payment.KEY_stdId, payment.stdId);
        values.put(Payment.KEY_groupId,payment.groupId);
        values.put(Payment.KEY_name, payment.name);
        db.update(Payment.TABLE, values, Payment.KEY_ID + "= ?", new String[] { String.valueOf(payment.payment_ID) });
        db.close();  //Закриваємо звязок з БД
    }

    public ArrayList<HashMap<String, String>>  getPaymentList() {
        //Відкриваємо БД тільки для читання
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Payment.KEY_ID + "," +
                Payment.KEY_name + "," +
                Payment.KEY_groupId + "," +
                Payment.KEY_stdId +
                " FROM " + Payment.TABLE;
        //Student student = new Student();
        ArrayList<HashMap<String, String>> paymentList = new ArrayList<HashMap<String, String>>();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> payment = new HashMap<String, String>();
                payment.put("id", cursor.getString(cursor.getColumnIndex(Payment.KEY_name)));
                payment.put("summ", cursor.getString(cursor.getColumnIndex(Payment.KEY_stdId)));
                payment.put("name", cursor.getString(cursor.getColumnIndex(Payment.KEY_groupId)));
                paymentList.add(payment);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return paymentList;
    }

    public Payment getPaymentById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Payment.KEY_ID + "," +
                Payment.KEY_name + "," +
                Payment.KEY_groupId + "," +
                Payment.KEY_stdId +
                " FROM " + Payment.TABLE
                + " WHERE " +
                Payment.KEY_ID + "=?";

        int iCount =0;
        Payment payment = new Payment();
        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );
        if (cursor.moveToFirst()) {
            do {
                payment.payment_ID =cursor.getInt(cursor.getColumnIndex(Payment.KEY_ID));
                payment.name =cursor.getString(cursor.getColumnIndex(Payment.KEY_name));
                payment.groupId  =cursor.getString(cursor.getColumnIndex(Payment.KEY_groupId));
                payment.stdId =cursor.getString(cursor.getColumnIndex(Payment.KEY_stdId));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return payment;
    }

}