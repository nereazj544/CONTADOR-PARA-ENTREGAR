package com.example.contador_para_entregar.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contador_para_entregar.R;

public class MainActivityLogin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        setContentView(R.layout.activity_inicar_sesion);

    }


    //INICIAR SESION
    public  void  nocuenta(View v){
        //Esto va a ir a la otra pantalla
        Intent nocuenta = new Intent(this, Registrarse.class);
        startActivity(nocuenta);
        finish();
    }

}
