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
        Button AutoClick = findViewById(R.id.AutoC);

       if (datum != null){
           //Datos que se recogeran de la base de datos interna del dispositivo.
           String numero = datum.getString("data");
           numerocont.setText("Tus puntos de Pasión y Amistad: " + numero);
           ocu.setText(numero); //Ignorar este
           String KK = datum.getString("animacion");


           String valorT = datum.getString("valor");
           String costoT = datum.getString("costo");
           String AcostT = datum.getString("AClik");
           String cotoTM = datum.getString("costo_mu");

           BigInteger valor = new BigInteger(valorT);
           BigInteger costo = new BigInteger(costoT);
           BigInteger costoM = new BigInteger(cotoTM);
           int ACost = Integer.parseInt(AcostT);


           //BOTONES
           /*
           Multiplicar.setText("Multiplicar costo: " + costo_multiplicacion);
           AutoClick.setText("AutoClick costo: " + ACcost);
           aumentar.setText("Aumetar Coste: " + costo);

            */

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

    public void autoclick(View v) {
        if (num.compareTo(ACcost) >= 0) {
            num = num.subtract(ACcost);
            valor = valor.add(new BigInteger("10"));
            ACcost = ACcost.add(new BigInteger("10"));
            AutoClick.setText("AutoClick coste: " + ACcost);
            AutoClick();

            // Actualiza los botones en MainActivity si es necesario
            Intent intent = new Intent();
            intent.putExtra("data", num.toString());
            setResult(RESULT_OK, intent);
        }
    }
    public void AutoClick(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            while(true){
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
                num = num.add(BigInteger.valueOf(auto));
                //Background work here
                handler.post(() -> {
                    //UI Thread work here
                    ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    fade_in.setDuration(100);
                    numerocont.setText(NumeroFormato(num));


                });}
        });

    }

    public String NumeroFormato(BigInteger val) {
        String foVal = "";
        if (val.compareTo(mil) >= 0 && val.compareTo(millon) < 0) {
            foVal = val.divide(mil) + "Mil";
            numerocont.setTextColor(Color.RED);
        } else if (val.compareTo(millon) >= 0 && val.compareTo(billon) < 0) {
            foVal = val.divide(millon) + "M";
            numerocont.setTextColor(Color.GREEN);
        } else if (val.compareTo(billon) >= 0) {
            foVal = val.divide(billon) + "B";
            numerocont.setTextColor(Color.CYAN);
        } else {
            foVal = val.toString();
        }
        return foVal;
    }
    //END APP
}