package com.example.contador_para_entregar.Login;

import android.provider.BaseColumns;

public class Database_estrucute {
    private Database_estrucute(){}
    public  static class  FeedEntry implements BaseColumns{
        //Nombre de la tabla
        public static final String TB_NAME = "Usuarios Creados";

        //Nombre de los campos
        public static final String CAMPO1_ID = "ID DEL USUARIO";
        public static final String CAMPO2 = "NOMBRE DE USUARIO";
        public static final String CAMPO3 = "CONTRASEÑA";

    }

    private static final String TEXT_TYPE = "TEXT";
    private  static final  String coma = ",";
    public static final  String SQL_CREATE = "CREATE TABLE " + FeedEntry.TB_NAME
            + " (" + FeedEntry.CAMPO1_ID + " INTERGER PRIMARY KEY, " +
            FeedEntry.CAMPO2 +  TEXT_TYPE + coma + FeedEntry.CAMPO3 + TEXT_TYPE +") ";
    public  static final String SQL_DELETE = "DROP TABLE IF EXISTS " + FeedEntry.TB_NAME;

}
