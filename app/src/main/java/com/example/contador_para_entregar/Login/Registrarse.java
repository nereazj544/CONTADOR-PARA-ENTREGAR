package com.example.contador_para_entregar.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.contador_para_entregar.MainActivity;
import com.example.contador_para_entregar.PantallaActivity;
import com.example.contador_para_entregar.R;

public class Registrarse extends AppCompatActivity {

    Button resesion;
    EditText reuser, recontra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        recontra = (EditText) findViewById(R.id.contra);
        reuser = (EditText) findViewById(R.id.name_user);
        resesion = (Button) findViewById(R.id.iniciar);

        final Database_Helper dbHelper = new Database_Helper(this);

        resesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues  values = new ContentValues();
                values.put(Database_estrucute.FeedEntry.CAMPO2,reuser.getText().toString());
                values.put(Database_estrucute.FeedEntry.CAMPO3,recontra.getText().toString());

                long newRowld = db.insert(Database_estrucute.FeedEntry.TB_NAME,
                        null, values);

                Toast.makeText(getApplicationContext(),
                        "Usuario registrado" + newRowld, Toast.LENGTH_SHORT).show();

                reuser.setTextColor(Color.WHITE);
                recontra.setTextColor(Color.WHITE);
            }
        });

    }





    public  void  cuenta(View v){
        //Para ir a la iniciar sesion de la cuenta.
        Intent in = new Intent(this, MainActivityLogin.class);
        startActivity(in);
        finish();
    }

    public void iniciar(View v){
        Intent inicar = new Intent(this, MainActivity.class);
        startActivity(inicar);
        finish();
    }





  
}