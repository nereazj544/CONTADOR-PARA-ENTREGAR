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

    BigInteger num = BigInteger.ZERO;
    BigInteger valor = BigInteger.ONE;
    BigInteger costo = new BigInteger("100");
    BigInteger costo_multiplicacion = new BigInteger("1000");
    /*Para no complicarse la vida con los ceros :) */
    BigInteger mil = new BigInteger("1000");
    BigInteger millon = new BigInteger("1000000");
    BigInteger billon = new BigInteger("1000000000");

    //AutoClick
    BigInteger ACcost = new BigInteger("10");
    int automatico = 1;
    int auto = 1;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercazuma);


        Intent intent = getIntent();
        Bundle datum = intent.getExtras();

        ocu = (TextView) findViewById(R.id.oc);
        numerocont = (TextView) findViewById(R.id.puntosclicks);
        Button aumentar = findViewById(R.id.aumentar);
        Button Multiplicar = findViewById(R.id.multiply);
        Button AC = findViewById(R.id.AutoC);

       if (datum.isEmpty()){
           //Datos que se recogeran de la base de datos interna del dispositivo.
       } else{
           String numero = datum.getString("data");
           numerocont.setText("Tus puntos de Pasión y Amistad: " + numero);
           ocu.setText(numero);
           String KK = datum.getString("animacion");

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
           //BOTONES
           Multiplicar.setText("Multiplicar costo: " + costo_multiplicacion);
           AC.setText("AutoClick costo: " + ACcost);
           aumentar.setText("Aumetar Coste: " + costo);

       }
    }

    public void volver(View v){
        Intent intent = new Intent();
        intent.putExtra("data", ocu.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
        /*
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
         */
    }



    //END APP
}