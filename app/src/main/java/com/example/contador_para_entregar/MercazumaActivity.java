package com.example.contador_para_entregar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MercazumaActivity extends AppCompatActivity {
    TextView numerocont;
    TextView ocu;
    Button AutoClick;
    Button Multiplicar;
    Button aumentar;

/*
    BigInteger num = BigInteger.ZERO;
    BigInteger valor = BigInteger.ONE;
    BigInteger costo = new BigInteger("100");
    BigInteger costo_multiplicacion = new BigInteger("1000");
    BigInteger mil = new BigInteger("1000");
    BigInteger millon = new BigInteger("1000000");
    BigInteger billon = new BigInteger("1000000000");
    //AutoClick
    BigInteger ACcost = new BigInteger("10");
    int automatico = 1;
    int auto = 1;

    */

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercazuma);


        Intent intent = getIntent();
        Bundle datum = intent.getExtras();

        ocu = (TextView) findViewById(R.id.oc);
        numerocont = (TextView) findViewById(R.id.puntosclicks);


       if (datum != null){
           //Datos que se recogeran de la base de datos interna del dispositivo.
           String numero = datum.getString("data");
           numerocont.setText("Tus puntos de Pasión y Amistad: " + numero);
           ocu.setText(numero); //Esto es para que pase en numero de que realmente se tiene.


           /*
           String valorT = datum.getString("valor");
           String costoT = datum.getString("costo");
           String AcostT = datum.getString("AClik");
           String cotoTM = datum.getString("costo_mu");



           BigInteger valor = new BigInteger(valorT);
           BigInteger costo = new BigInteger(costoT);
           BigInteger costoM = new BigInteger(cotoTM);
           int ACost = Integer.parseInt(AcostT);
           */
       }
    }

    public void volver(View v){
        Intent intent = new Intent();
        intent.putExtra("data", ocu.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }




    //END APP
}