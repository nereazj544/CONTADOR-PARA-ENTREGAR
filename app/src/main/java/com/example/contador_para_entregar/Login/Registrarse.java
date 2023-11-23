package com.example.contador_para_entregar.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.contador_para_entregar.PantallaActivity;
import com.example.contador_para_entregar.R;

public class Registrarse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
    }





    public  void  cuenta(View v){
        //Esto va a ir a la otra pantalla
        Intent in = new Intent(this, InicarSesion.class);
        startActivity(in);
        finish();
    }

    public void iniciar(View v){
        Intent log = new Intent(this, PantallaActivity.class);
        startActivity(log);
        finish();
    }
}