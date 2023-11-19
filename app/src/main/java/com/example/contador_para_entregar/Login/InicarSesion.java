package com.example.contador_para_entregar.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.contador_para_entregar.PantallaActivity;
import com.example.contador_para_entregar.R;

public class InicarSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicar_sesion);
    }



    public  void  nocuenta(View v){
        //Esto va a ir a la otra pantalla
        Intent in = new Intent(this, Registrarse.class);
        startActivity(in);
        finish();
    }

    public void loging(View v){
        Intent log = new Intent(this, PantallaActivity.class);
        startActivity(log);
        finish();
    }
}