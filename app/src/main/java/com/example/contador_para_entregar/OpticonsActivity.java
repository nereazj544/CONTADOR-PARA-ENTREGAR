package com.example.contador_para_entregar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OpticonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opticons);
    }
    public  void  volver(View v){
        //Esto va a ir a la otra pantalla
        Intent in = new Intent(this, PantallaActivity.class);
        startActivity(in);
        finish();
    }
}