package com.example.contador_para_entregar.Login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database_Helper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1; //vesrion de la Database
    public static final String DATABASE_NAME = "usuarios.db"; //nombre de la base
    public Database_Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Database_estrucute.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(Database_estrucute.SQL_DELETE);
    onCreate(db);
    }
  
}
