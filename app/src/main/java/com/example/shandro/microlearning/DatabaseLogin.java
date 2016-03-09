package com.example.shandro.microlearning;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shandro on 12/4/2015.
 */
public class DatabaseLogin extends SQLiteOpenHelper {

    private static final String DB_NAME = "Micro"; // the name of our database
    private static final int DB_VERSION = 2; // the version of the database

    public DatabaseLogin(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        ContentValues content1 = new ContentValues();
        content1.put("pin", 12345);
        content1.put("password", "hello");

        ContentValues content2 = new ContentValues();
        content2.put("pin", 123456);
        content2.put("password", "hello");

        ContentValues content3 = new ContentValues();
        content3.put("pin", 1234567);
        content3.put("password", "hello");



        String query = "CREATE TABLE login (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "pin TEXT, "
                + "password TEXT "
                + ");";
        db.execSQL(query);


        db.insert("login", null, content1);
        db.insert("login", null, content2);
        db.insert("login", null, content3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "CREATE TABLE score(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "pin TEXT, "
                + "high INTEGER "
                + ");";

        db.execSQL(query);
    }
}
