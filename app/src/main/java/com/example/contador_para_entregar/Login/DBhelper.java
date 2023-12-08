package com.example.contador_para_entregar.Login;

import static org.xmlpull.v1.XmlPullParser.TEXT;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public static final int version =1;
    public  static  final String name = "user.db";

    //TABLA
    public  static  final String NombreTabla ="tabla";
    public  static  final String Campo1id ="usuario";
    public  static  final String Campo2 ="password";

    //Tienda (en caso de que llegase a funcionar en algun momento)
    public  static final String Campo3 = "puntos";
    public  static  final String Campo4  = "compras";
    public  static  final String Campo5 = "autoclick";



    public DBhelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQLcreate = "CREATE TABLE " + NombreTabla + " (" + Campo1id + " TEXT PRIMARY KEY,"
                + Campo2 + " TEXT);";
        db.execSQL(SQLcreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("Drop table if exists tabla");
            onCreate(db);
    }

    //Insertar Datos
    public  boolean insertDatos (String user, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Campo1id, user);
        values.put(Campo2, pass);


        long result = db.insert(NombreTabla, null, values);
        if (result == -1)  return true;
        else return false;
    }


    //Chequear los nombres de usuario
    public boolean OkUser(String user){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tabla where usuario = ?", new String[]{user});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }

    //Chequear ambas
    public boolean OkSP(String user, String pass){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(
                "select * from tabla where password = ? " +
                        "and usuario = ?",
                new String[]{pass, user});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }






}//END APP


