package com.example.contador_para_entregar.Login;

import android.provider.BaseColumns;

public class Database_estrucute {
    private Database_estrucute(){}
    public  static class  FeedEntry implements BaseColumns{
        //Nombre de la tabla
        public static final String TB_NAME = "Usuarios Creados";

        //Nombre de los campos
        public static final String CAMPO1id = "NOMBRE_DE_USUARIO";
        public static final String CAMPO2 = "CONTRASEÑA";

    }

    private static final String TEXT_TYPE = "TEXT";
    private  static final  String coma = ",";
    public static final  String SQL_CREATE = "CREATE TABLE " + FeedEntry.TB_NAME
            + " (" + FeedEntry.CAMPO1id + " INTERGER PRIMARY KEY, " +
              TEXT_TYPE + coma + FeedEntry.CAMPO2 + TEXT_TYPE +") ";
    public  static final String SQL_DELETE = "DROP TABLE IF EXISTS " + FeedEntry.TB_NAME;

}
